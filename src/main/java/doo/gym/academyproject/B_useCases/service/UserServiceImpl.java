package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.interfaces.UserDAO;
import doo.gym.academyproject.B_useCases.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public void add(User user) throws Exception{
        if(isUserValid(user)){
            userDAO.insertUser(user);
        }else{
            throw new Exception("erro ao adicionar usuario");
        }
    }

    @Override
    public boolean remove(double id) {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(double id, User user) throws Exception{
        if(user != null){
            userDAO.updateUser(id, user);
            return true;
        }else{
            throw new Exception("erro ao atualizar usuario");
        }
    }

    @Override
    public List<User> list() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User getUserById(double id){
        return userDAO.getUserById(id);
    }

    private boolean isUserValid(User user){
        if(userDAO.getUserByEmail(user.getEmail()) != null){
            return false;
        }
        if(user.getPassword().length() < 6){
            return false;
        }
        return user.getName().length() >= 3;
    }

}
