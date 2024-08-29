package doo.gym.academyproject.UseCase.service.interfaces;


import doo.gym.academyproject.Entity.User;
import java.util.List;

//interface responsavel por fazer a adição de usuarios no sistema
//o uso da interface é pensando no principio de inversao de dependencias
public interface UserService{

    void add(User user) throws Exception;
    boolean remove(double id);
    boolean update(double id, User user) throws Exception;
    List<User> list();
    User getUserByEmail(String email);
    public User getUserById(double id);



}
