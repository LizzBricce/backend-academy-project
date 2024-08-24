package doo.gym.academyproject.B_useCases.DAOImpl;


import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;
import doo.gym.academyproject.A_entity.PhysicalCharacteristics;
import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.DAOInterfaces.PhyCharacteristicsDAO;
import org.springframework.stereotype.Repository;

@Repository
public class PhyCharacteristicsDAOImpl implements PhyCharacteristicsDAO {


    @Override
    public void addCharacteristics(User user, PhysicalCharacteristics characteristics) {
        user.setCharacteristics(characteristics);
    }

    @Override
    public void updateWeight(User user, double weight) {
        user.getCharacteristics().setWeight(weight);
    }

    @Override
    public void updateHeight(User user, double height) {
        user.getCharacteristics().setHeight(height);
    }

    @Override
    public void updateGoal(User user, String physicalGoal) {
        user.getCharacteristics().setPhysicalGoal(PhysicalGoal.valueOf(physicalGoal));
    }
}
