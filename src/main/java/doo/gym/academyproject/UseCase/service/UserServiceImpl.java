package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.interfacesDAO.UserDAO;
import doo.gym.academyproject.UseCase.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe responsavel por gerenciar os metodos referentes a usuario
 */
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
    public boolean remove(double id) throws Exception  {
        if(isUserValid(userDAO.getUserById(id))){
            return userDAO.delete(id);
        }else{
            throw new Exception("erro ao remover usuario");
        }
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
