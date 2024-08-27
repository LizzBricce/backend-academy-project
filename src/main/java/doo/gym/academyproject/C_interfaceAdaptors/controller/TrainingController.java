package doo.gym.academyproject.C_interfaceAdaptors.controller;

import doo.gym.academyproject.A_Entities.Training;
import doo.gym.academyproject.B_useCases.service.APIServiceImpl;
import doo.gym.academyproject.B_useCases.service.TrainingSeparationService;
import doo.gym.academyproject.C_interfaceAdaptors.exception.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingSeparationService trainingSeparationService;

    @GetMapping
    public Map<String, String> showTrainings() throws Exception{
        try {
            String clearText = APIServiceImpl.getLastGeneratedTraining();

            if (clearText == null || clearText.isEmpty()) {
                throw new ProjectException("Nenhum treino encontrado.");
            }

            Training training = trainingSeparationService.separateTraining(clearText);

            Map<String, String> trainingMap = new HashMap<>();
            trainingMap.put("trainingA", training.getTrainingA());
            trainingMap.put("trainingB", training.getTrainingB());
            trainingMap.put("trainingC", training.getTrainingC());

            return trainingMap;
        }catch (ProjectException e){
            throw new ProjectException(e.getMessage());
        }
    }
}

