package doo.gym.academyproject.UseCase.service.interfaces;

import doo.gym.academyproject.UseCase.dto.UserDTO;

public interface APIService {
    String generateTraining(UserDTO loggedInUser) throws Exception;
}
