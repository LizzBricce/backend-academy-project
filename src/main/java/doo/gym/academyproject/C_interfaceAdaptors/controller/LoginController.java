package doo.gym.academyproject.C_interfaceAdaptors.controller;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.dto.LoginDTO;
import doo.gym.academyproject.B_useCases.service.interfaces.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginUseCase) {
        this.loginService = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        User user = loginService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("senha ou email invalidos");
        }
    }
}
