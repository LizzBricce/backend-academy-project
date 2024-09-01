package doo.gym.academyproject.UseCase.service.interfaces;


import doo.gym.academyproject.Entity.User;
import java.util.List;

/**
 * Define os metodos implementados na classe UserServiceImpl
 *
 * o uso de interfaces segue o principio da inversão de dependências,
 * fazendo com que as outras classes dependam de abstrações e não da implementação
 */
public interface UserService{

    void add(User user) throws Exception;
    boolean remove(double id) throws Exception;
    boolean update(double id, User user) throws Exception;
    List<User> list();
    User getUserByEmail(String email);
    public User getUserById(double id);



}
