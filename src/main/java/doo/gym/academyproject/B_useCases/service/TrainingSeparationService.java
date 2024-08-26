package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.Training;
import doo.gym.academyproject.C_interfaceAdaptors.utils.SeparateTraining;
import org.springframework.stereotype.Service;

@Service
public class TrainingSeparationService {
    public Training separateTraining(String clearText) {
        Training separatedTraining = SeparateTraining.splitTraining(clearText);
        separatedTraining.setFullTraining(clearText);
        return separatedTraining;
    }
}
