package doo.gym.academyproject.B_useCases.DAOImpl;

import doo.gym.academyproject.A_Entities.Enuns.FitnessGoal;
import doo.gym.academyproject.A_Entities.PhysicalProfile;
import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.PhysicalProfileDAO;
import org.springframework.stereotype.Repository;

@Repository
public class PhysicalProfileDAOImpl implements PhysicalProfileDAO {

    @Override
    public void addPhysicalProfile(User user, PhysicalProfile physicalProfile) {
        user.setPhysicalProfile(physicalProfile);
    }

    @Override
    public void updateWeight(User user, double weight) {
        PhysicalProfile currentProfile = user.getPhysicalProfile();
        PhysicalProfile updatedProfile = new PhysicalProfile.PhysicalProfileBuilder()
                .bodyWeight(weight)
                .bodyHeight(currentProfile.getBodyHeight())
                .gender(currentProfile.getGender())
                .age(currentProfile.getAge())
                .fitnessGoal(currentProfile.getFitnessGoal())
                .build();
        user.setPhysicalProfile(updatedProfile);
    }

    @Override
    public void updateHeight(User user, double height) {
        PhysicalProfile currentProfile = user.getPhysicalProfile();
        PhysicalProfile updatedProfile = new PhysicalProfile.PhysicalProfileBuilder()
                .bodyWeight(currentProfile.getBodyWeight())
                .bodyHeight(height)
                .gender(currentProfile.getGender())
                .age(currentProfile.getAge())
                .fitnessGoal(currentProfile.getFitnessGoal())
                .build();
        user.setPhysicalProfile(updatedProfile);
    }

    @Override
    public void updateGoal(User user, String fitnessGoal) {
        PhysicalProfile currentProfile = user.getPhysicalProfile();
        PhysicalProfile updatedProfile = new PhysicalProfile.PhysicalProfileBuilder()
                .bodyWeight(currentProfile.getBodyWeight())
                .bodyHeight(currentProfile.getBodyHeight())
                .gender(currentProfile.getGender())
                .age(currentProfile.getAge())
                .fitnessGoal(FitnessGoal.valueOf(fitnessGoal))
                .build();
        user.setPhysicalProfile(updatedProfile);
    }
}

