package doo.gym.academyproject.B_useCases.DAOInterfaces;

import doo.gym.academyproject.A_entity.User;
import java.util.List;

public interface UserDAO {

    void insertUser(User user) throws Exception;
    boolean delete(double id);
    List<User> getAllUsers();
    User getUserById(double id);
    User getUserByEmail(String email);
    void updateUser(double id, User updatedUser);
}
