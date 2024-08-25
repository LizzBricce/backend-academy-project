package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class APIController {

    @Autowired
    private APIService apiService;

    @PostMapping("/generate_training")
    public ResponseEntity<?> generateTraining(@RequestBody User user) throws Exception {
        var training = apiService.generateTraining(user);

        if(training != null) return  ResponseEntity.ok(new Object() {
            public String successMessage = "Treino gerado com sucesso";
            public String traning = training;
        });

        return  ResponseEntity.ok(new Object() {
            public String errorMessage = "Não foi possível gerar o treino.";
        });
    }

}
