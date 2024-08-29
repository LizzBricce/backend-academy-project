package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.Entity.PhysicalProfile;
import doo.gym.academyproject.Entity.User;

public interface PhysicalProfileDAO {
    void addPhysicalProfile(User user, PhysicalProfile physicalProfile);
    void updateWeight(User user, double weight);
    void updateHeight(User user, double height);
    void updateGoal(User user, String physicalGoal);
}