package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.interfaces.UserDAO;
import doo.gym.academyproject.UseCase.service.interfaces.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO;

    public LoginServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
