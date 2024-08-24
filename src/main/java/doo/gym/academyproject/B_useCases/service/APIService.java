package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.PhysicalProfile;
import doo.gym.academyproject.A_entity.TrainingDetails;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.dto.PhysicalProfileDTO;
import doo.gym.academyproject.B_useCases.dto.PromptBuilder;
import doo.gym.academyproject.C_interfaceAdaptors.controllers.APIRequest;
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

    @Autowired
    private PromptBuilder promptBuilder;

    private final RestTemplate restTemplate;

    public APIService() {

        this.restTemplate = new RestTemplate();
    }


    public String generateTraining(User loggedInUser) throws Exception {
        if (loggedInUser != null && loggedInUser.getPhysicalProfile() != null) {
            PhysicalProfile physicalProfile = loggedInUser.getPhysicalProfile();
            PhysicalProfileDTO physicalProfileDTO = new PhysicalProfileDTO(
                    physicalProfile.getGender(),
                    physicalProfile.getFitnessGoal(),
                    physicalProfile.getAge(),
                    physicalProfile.getBodyHeight(),
                    physicalProfile.getBodyWeight()
            );

            String prompt = promptBuilder.createPrompt(physicalProfileDTO); // Usar a nova classe
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
        return null;
    }
}

