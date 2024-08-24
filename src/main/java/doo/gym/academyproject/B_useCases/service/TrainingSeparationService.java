package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_entity.TrainingDetails;
import doo.gym.academyproject.C_interfaceAdaptors.utils.SeparateTraining;
import org.springframework.stereotype.Service;

@Service
public class TrainingSeparationService {
    public TrainingDetails separateTraining(String clearText) {
        TrainingDetails separatedTraining = SeparateTraining.splitTraining(clearText);
        separatedTraining.setFullTraining(clearText);
        return separatedTraining;
    }
}
