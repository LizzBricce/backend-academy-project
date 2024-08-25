package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_entity.Training;
import doo.gym.academyproject.B_useCases.service.TrainingSeparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrainingController {

    @Autowired
    private TrainingSeparationService trainingSeparationService;

    @GetMapping("/trainings")
    public Map<String, String> showTrainings() {
        String clearText = "todos os treinos Treino A, Treino B, Treino C";

        Training training = trainingSeparationService.separateTraining(clearText);

        Map<String, String> trainingMap = new HashMap<>();
        trainingMap.put("trainingA", training.getTrainingA());
        trainingMap.put("trainingB", training.getTrainingB());
        trainingMap.put("trainingC", training.getTrainingC());

        return trainingMap;
    }
}

