package doo.gym.academyproject.C_interfaceAdaptors.controller;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.dto.UserDTO;
import doo.gym.academyproject.B_useCases.service.APIServiceImpl;
import doo.gym.academyproject.B_useCases.service.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class APIController {

    @Autowired
    private APIServiceImpl apiService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/generate_training")
    public ResponseEntity<?> generateTraining(@RequestBody User user) {
        try {
            UserDTO userDTO = userMapper.toDTO(user);
            String training = apiService.generateTraining(userDTO);

            if (training != null) {
                return ResponseEntity.ok(new ResponseMessage("Treino gerado com sucesso", training));
            } else {
                return ResponseEntity.ok(new ResponseMessage("Não foi possível gerar o treino.", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseMessage("erro ao gerar o treino: " + e.getMessage(), null));
        }
    }

    private static class ResponseMessage {
        public String message;
        public String training;

        public ResponseMessage(String message, String training) {
            this.message = message;
            this.training = training;
        }
    }
}
