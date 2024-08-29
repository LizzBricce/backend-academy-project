package doo.gym.academyproject.InterfaceAdaptors.controller;

import doo.gym.academyproject.Entity.Training;
import doo.gym.academyproject.UseCase.service.APIServiceImpl;
import doo.gym.academyproject.UseCase.service.TrainingSeparationService;
import doo.gym.academyproject.InterfaceAdaptors.exception.ProjectException;
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

