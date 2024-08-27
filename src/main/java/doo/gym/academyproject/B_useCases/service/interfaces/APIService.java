package doo.gym.academyproject.B_useCases.service.interfaces;

import doo.gym.academyproject.B_useCases.dto.UserDTO;

public interface APIService {
    String generateTraining(UserDTO loggedInUser) throws Exception;
}
