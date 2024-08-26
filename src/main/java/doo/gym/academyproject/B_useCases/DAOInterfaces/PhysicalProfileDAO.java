package doo.gym.academyproject.B_useCases.DAOInterfaces;

import doo.gym.academyproject.A_Entities.PhysicalProfile;
import doo.gym.academyproject.A_Entities.User;

public interface PhysicalProfileDAO {
    void addPhysicalProfile(User user, PhysicalProfile physicalProfile);
    void updateWeight(User user, double weight);
    void updateHeight(User user, double height);
    void updateGoal(User user, String physicalGoal);
}