package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.dto.LoginDTO;
import doo.gym.academyproject.B_useCases.service.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class LoginController {

    private final Login loginUseCase;

    public User user;

    public LoginController(Login loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO login) {
        User user = loginUseCase.authenticateUser(login.getEmail(), login.getPassword());
        if(user != null) return  ResponseEntity.ok(user);
        return  ResponseEntity.ok(new Object() {
            public String errorMessage = "Erro ao fazer login";
        });
    }
}
