package doo.gym.academyproject.InterfaceAdaptors.dao;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.interfacesDAO.UserDAO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa os dados de gerenciamento de usuario definidos pela classe UserDAO
 *
 * armazena os usuarios em um ArrayList
 */
@Component
public class UserDAOImpl implements UserDAO {
    private final List<User> users = new ArrayList<>();

    @Override
    public void insertUser(User user){
        user.setId(users.size() + 1);
        users.add(user);
    }

    @Override
    public boolean delete(double id) {
        return users.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User getUserById(double id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void updateUser(double id, User updatedUser) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setPhysicalProfile(updatedUser.getPhysicalProfile());
            user.setTraining(updatedUser.getTraining());
        }
    }

}
