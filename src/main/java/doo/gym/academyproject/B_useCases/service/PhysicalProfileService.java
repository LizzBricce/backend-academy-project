package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.PhysicalProfile;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.PhysicalProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalProfileService {

    private final PhysicalProfileDAO physicalProfileDAO;

    @Autowired
    public PhysicalProfileService(PhysicalProfileDAO physicalProfileDAO) {
        this.physicalProfileDAO = physicalProfileDAO;
    }
    public void addPhysicalProfile(User user, PhysicalProfile physicalProfile) {
        if (user != null) {
            physicalProfileDAO.addPhysicalProfile(user, physicalProfile);
        }
    }

    public void updateGoal(User user, String physicalGoal) {
        if (user != null && user.getPhysicalProfile() != null) {
            physicalProfileDAO.updateGoal(user, physicalGoal);
        }
    }

    public void updateWeight(User user, double weight) {
        if (user != null && user.getPhysicalProfile() != null) {
            physicalProfileDAO.updateWeight(user, weight);
        }
    }

    public void updateHeight(User user, double height) {
        if (user != null && user.getPhysicalProfile() != null) {
            physicalProfileDAO.updateHeight(user, height);
        }
    }
}