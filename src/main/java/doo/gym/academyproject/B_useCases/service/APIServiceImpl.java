package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.Training;
import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.dto.PhysicalProfileDTO;
import doo.gym.academyproject.B_useCases.dto.PromptBuilder;
import doo.gym.academyproject.B_useCases.dto.APIClient;
import doo.gym.academyproject.B_useCases.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class APIServiceImpl implements APIService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.link}")
    private String apiLink;

    private final APIClient apiClient;
    private final JSONProcessingService jsonProcessingService;
    private final TrainingSeparationService trainingSeparationService;
    private final PromptBuilder promptBuilder;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PhysicalProfileMapper physicalProfileMapper;

    public APIServiceImpl(APIClient apiClient, JSONProcessingService jsonProcessingService,
                          TrainingSeparationService trainingSeparationService, PromptBuilder promptBuilder,
                          UserService userService, UserMapper userMapper, PhysicalProfileMapper physicalProfileMapper) {
        this.apiClient = apiClient;
        this.jsonProcessingService = jsonProcessingService;
        this.trainingSeparationService = trainingSeparationService;
        this.promptBuilder = promptBuilder;
        this.userService = userService;
        this.userMapper = userMapper;
        this.physicalProfileMapper = physicalProfileMapper;
    }

    @Override
    public String generateTraining(UserDTO loggedInUserDTO) throws Exception {
        if (loggedInUserDTO != null && loggedInUserDTO.getPhysicalProfile() != null) {
            PhysicalProfileDTO physicalProfileDTO = loggedInUserDTO.getPhysicalProfile();
            String prompt = promptBuilder.createPrompt(physicalProfileDTO);
            APIRequest request = new APIRequest(prompt);
            ResponseEntity<String> responseEntity = apiClient.sendRequest(apiLink + apiKey, request);

            String responseBody = responseEntity.getBody();
            String clearText = jsonProcessingService.processAPIResponse(responseBody);
            Training separatedTraining = trainingSeparationService.separateTraining(clearText);

            User user = userMapper.toEntity(loggedInUserDTO);
            user.setTraining(separatedTraining);
            userService.update(user.getId(), user);

            return clearText;
        }
        return null;
    }
}
