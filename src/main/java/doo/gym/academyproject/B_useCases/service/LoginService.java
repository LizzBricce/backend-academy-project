package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.User;

public interface LoginService {

    User authenticateUser(String email, String password);
}