package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.PhysicalCharacteristics;
import doo.gym.academyproject.A_entity.TrainingDetails;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.dto.PhyCharacteristicsDTO;
import doo.gym.academyproject.C_interfaceAdaptors.controllers.APIRequest;
import doo.gym.academyproject.C_interfaceAdaptors.infra.JSONFormatting;
import doo.gym.academyproject.C_interfaceAdaptors.utils.SeparateTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.link}")
    private String apiLink;

    @Autowired
    private UserService userService;

    @Autowired
    private JSONProcessingService jsonProcessingService;

    @Autowired
    private TrainingSeparationService trainingSeparationService;

    private final RestTemplate restTemplate;

    public APIService() {

        this.restTemplate = new RestTemplate();
    }

    public String generateTraining(User loggedInUser) throws Exception {

        if (loggedInUser != null) {
            if (loggedInUser.getCharacteristics() != null) {

                PhysicalCharacteristics characteristics = loggedInUser.getCharacteristics();
                PhyCharacteristicsDTO phyCharacteristicsDTO = new PhyCharacteristicsDTO(
                        characteristics.getGender(),
                        characteristics.getPhysicalGoal()
                );

                String prompt = phyCharacteristicsDTO.toString();
                APIRequest request = new APIRequest(prompt);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<APIRequest> requestEntity = new HttpEntity<>(request, headers);

                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        apiLink + apiKey,
                        HttpMethod.POST,
                        requestEntity,
                        String.class
                );

                String responseBody = responseEntity.getBody();
                String clearText = jsonProcessingService.processAPIResponse(responseBody);
                TrainingDetails separatedTraining = trainingSeparationService.separateTraining(clearText);

                loggedInUser.setTraining(separatedTraining);
                userService.update(loggedInUser.getId(), loggedInUser);

                return clearText;
            }
        }
        return null;
    }
}

