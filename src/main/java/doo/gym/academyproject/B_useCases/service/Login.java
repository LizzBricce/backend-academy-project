package doo.gym.academyproject.B_useCases.service;


import doo.gym.academyproject.A_entity.User;

public interface Login {

    User authenticateUser(String email, String password);
}