package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.dto.LoginDTO;
import doo.gym.academyproject.B_useCases.service.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class LoginController {

    private final Login loginUseCase;

    public LoginController(Login loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        User user = loginUseCase.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("senha ou email invalidos");
        }
    }
}
