package doo.gym.academyproject.C_interfaceAdaptors.controllers;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/physicalProfile") //atualizar caminho no front tb
@CrossOrigin(allowedHeaders = "*")
public class PhysicalProfileController {

    private final UserService userService;

    @Autowired
    public PhysicalProfileController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPhysicalProfile(@RequestBody User user) { //melhorar
        try {
            User existingUser = userService.getUserById(user.getId());
            if (existingUser != null) {
                existingUser.setPhysicalProfile(user.getPhysicalProfile());
                userService.update(existingUser.getId(), existingUser);
                return ResponseEntity.ok(new Object() {
                    public String successMessage = "Caracteristicas adicionadas com sucesso.";
                });
            } else {
                return ResponseEntity.ok(new Object() {
                    public String errorMessage = "Não foi possível encontrar o usuário.";
                });
            }
        } catch (Exception e) {
            return ResponseEntity.ok(new Object() {
                public String errorMessage = "Não foi adicionar caracteristica ao usuário." + e.getMessage();
            });
        }
    }
}
