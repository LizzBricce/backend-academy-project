package doo.gym.academyproject.B_useCases.DAOInterfaces;

import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;
import doo.gym.academyproject.A_entity.PhysicalCharacteristics;
import doo.gym.academyproject.A_entity.User;


public interface PhyCharacteristicsDAO {
    void addCharacteristics(User user, PhysicalCharacteristics characteristics);
    void updateWeight(User user, double weight);
    void updateHeight(User user, double height);
    void updateGoal(User user, String physicalGoal);
}