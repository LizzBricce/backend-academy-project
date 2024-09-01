package doo.gym.academyproject.InterfaceAdaptors.controller;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.dto.LoginDTO;
import doo.gym.academyproject.UseCase.service.interfaces.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador web responsavel pelo endpoint referente a login
 */
@RestController
@CrossOrigin(allowedHeaders = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginUseCase) {
        this.loginService = loginUseCase;
    }

    /**
     * endpoint /login que recebe os dados de login e devolve o usuario caso o login esteja correto ou uma mensagem de erro
     */
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
