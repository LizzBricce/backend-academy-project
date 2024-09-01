package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.Entity.User;
import java.util.List;

/**
 * Interface de UserDAOImpl, esta na camada de UseCase para ser usada pelas classes de serviço sem romper as camadas
 * a implementação fica na camada acima para estar mais proxima de um possivel banco de dados e para facilitar a manutenção
 */
public interface UserDAO {

    void insertUser(User user) throws Exception;
    boolean delete(double id);
    List<User> getAllUsers();
    User getUserById(double id);
    User getUserByEmail(String email);
    void updateUser(double id, User updatedUser);
}
