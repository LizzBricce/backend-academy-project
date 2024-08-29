package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.Entity.User;
import java.util.List;

public interface UserDAO {

    void insertUser(User user) throws Exception;
    boolean delete(double id);
    List<User> getAllUsers();
    User getUserById(double id);
    User getUserByEmail(String email);
    void updateUser(double id, User updatedUser);
}
