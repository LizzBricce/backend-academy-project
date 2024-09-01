package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.Entity.PhysicalProfile;
import doo.gym.academyproject.Entity.User;
/**
 * Interface de PhysicalProfileDAOImpl, esta na camada de UseCase para ser usada pelas classes de serviço sem romper as camadas
 * a implementação fica na camada acima para estar mais proxima de um possivel banco de dados e para facilitar a manutenção
 */
public interface PhysicalProfileDAO {
    void addPhysicalProfile(User user, PhysicalProfile physicalProfile);
    void updateWeight(User user, double weight);
    void updateHeight(User user, double height);
    void updateGoal(User user, String physicalGoal);
}