package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;
import doo.gym.academyproject.A_entity.PhysicalCharacteristics;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.PhyCharacteristicsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhyCharacteristicsService {

    private final PhyCharacteristicsDAO characteristicsDAO;

    @Autowired
    public PhyCharacteristicsService(PhyCharacteristicsDAO characteristicsDAO) {
        this.characteristicsDAO = characteristicsDAO;
    }

    public void addCharacteristics(User user, PhysicalCharacteristics characteristics) {
        if (user != null) {
            characteristicsDAO.addCharacteristics(user, characteristics);
        }
    }

    public void updateGoal(User user, String physicalGoal) {
        if (user != null && user.getCharacteristics() != null) {
            characteristicsDAO.updateGoal(user, physicalGoal);
        }
    }

    public void updateWeight(User user, double weight) {
        if (user != null && user.getCharacteristics() != null) {
            characteristicsDAO.updateWeight(user, weight);
        }
    }

    public void updateHeight(User user, double height) {
        if (user != null && user.getCharacteristics() != null) {
            characteristicsDAO.updateHeight(user, height);
        }
    }
}