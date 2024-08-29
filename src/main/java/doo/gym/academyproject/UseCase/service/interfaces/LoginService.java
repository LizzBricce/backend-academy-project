package doo.gym.academyproject.UseCase.service.interfaces;

import doo.gym.academyproject.Entity.User;

public interface LoginService {

    User authenticateUser(String email, String password);
}