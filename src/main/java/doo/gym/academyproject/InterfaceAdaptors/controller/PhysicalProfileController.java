package doo.gym.academyproject.InterfaceAdaptors.controller;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/physicalProfile")
@CrossOrigin(allowedHeaders = "*")
public class PhysicalProfileController {

    private final UserService userService;

    @Autowired
    public PhysicalProfileController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPhysicalProfile(@RequestBody User user) {
        try {
            User existingUser = userService.getUserById(user.getId());
            if (existingUser != null) {
                existingUser.setPhysicalProfile(user.getPhysicalProfile());
                userService.update(existingUser.getId(), existingUser);

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Caracteristicas adicionadas com sucesso.");
            } else {
                    throw new Exception("Não foi possível encontrar o usuário.");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
