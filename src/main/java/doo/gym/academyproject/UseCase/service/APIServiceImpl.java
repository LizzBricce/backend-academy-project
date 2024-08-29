package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.Entity.Training;
import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.dto.PhysicalProfileDTO;
import doo.gym.academyproject.UseCase.service.interfaces.APIService;
import doo.gym.academyproject.UseCase.service.interfaces.UserService;
import doo.gym.academyproject.UseCase.service.util.PromptBuilder;
import doo.gym.academyproject.UseCase.interfacesDAO.APIClientDAO;
import doo.gym.academyproject.UseCase.dto.UserDTO;
import doo.gym.academyproject.UseCase.service.util.mapper.PhysicalProfileMapper;
import doo.gym.academyproject.UseCase.service.util.mapper.UserMapper;
import doo.gym.academyproject.UseCase.service.request.APIRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class APIServiceImpl implements APIService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.link}")
    private String apiLink;

    private final APIClientDAO apiClientDAO;
    private final JSONProcessingService jsonProcessingService;
    private final TrainingSeparationService trainingSeparationService;
    private final PromptBuilder promptBuilder;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PhysicalProfileMapper physicalProfileMapper;

    private static String lastGeneratedTraining = null;


    public APIServiceImpl(APIClientDAO apiClientDAO, JSONProcessingService jsonProcessingService,
                          TrainingSeparationService trainingSeparationService, PromptBuilder promptBuilder,
                          UserService userService, UserMapper userMapper, PhysicalProfileMapper physicalProfileMapper) {
        this.apiClientDAO = apiClientDAO;
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
            ResponseEntity<String> responseEntity = apiClientDAO.sendRequest(apiLink + apiKey, request);

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

    public static String getLastGeneratedTraining() {
        return lastGeneratedTraining;
    }
}
