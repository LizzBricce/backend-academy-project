package doo.gym.academyproject.B_useCases.DAOImpl;


import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.UserDAO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl instance;
    private final List<User> users;

    public UserDAOImpl() {
        users = new ArrayList<>();
    }
    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public void insertUser(User user){
        user.setId(users.size() + 1); ///////////
        users.add(user);
    }

    @Override
    public boolean delete(double id) {
        for(User u : users){
            if (u.getId() == id){
                return users.remove(u); //remove o usuario
            }
        }
        return false; //se não achar o usuario
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(double id) {
       for (User u : users){
           if (u.getId() == id){
               return u; //retorna o usuario
           }
       }
       return null; //se não achar o usuario
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u: users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public void updateUser(double id, User updatedUser) { //
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setCharacteristics(updatedUser.getCharacteristics());
                user.setTraining(updatedUser.getTraining());
                break;
            }
        }
    }

}
