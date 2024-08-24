package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.PhysicalProfile;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PhysicalProfileService physicalProfileService;

    public UserServiceImpl(UserDAO userDAO, PhysicalProfileService physicalProfileService){
        this.userDAO = userDAO;
        this.physicalProfileService = physicalProfileService;
    }

    @Override
    public void add(User user) throws Exception{
        if(isUserValid(user)){
            userDAO.insertUser(user);
        }else{
            throw new Exception("error adding user");
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
            throw new Exception("error when updating user");
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

    public void addCharacteristicsToUser(double userId, PhysicalProfile characteristics) throws Exception {
        User user = getUserById(userId);
        if (user != null) {
            physicalProfileService.addCharacteristics(user, characteristics);
            update(userId, user);
        } else {
            throw new Exception("nao :c");
        }
    }
    private boolean isUserValid(User user){
        if(userDAO.getUserByEmail(user.getEmail()) != null){
            return false;
        }
        if(user.getPassword().length() < 6){
            return false;
        }
        if(user.getName().length() < 3){
            return false;
        }
        return true;
    }

}
