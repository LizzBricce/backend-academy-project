package doo.gym.academyproject.UseCase.service;

import doo.gym.academyproject.Entity.Training;
import doo.gym.academyproject.UseCase.service.util.SeparateTraining;
import org.springframework.stereotype.Service;
/**
 * Classe responsavel por encaminhar o texto recebido para ser separado e devolve ele dividido
 */
@Service
public class TrainingSeparationService {
    public Training separateTraining(String clearText) {
        Training separatedTraining = SeparateTraining.splitTraining(clearText);
        separatedTraining.setFullTraining(clearText);
        return separatedTraining;
    }
}
