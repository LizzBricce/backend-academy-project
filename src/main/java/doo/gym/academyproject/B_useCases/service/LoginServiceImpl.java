package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.UserDAO;
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
