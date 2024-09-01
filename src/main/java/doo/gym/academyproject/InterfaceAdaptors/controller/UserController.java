package doo.gym.academyproject.InterfaceAdaptors.controller;


import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.service.interfaces.UserService;
import doo.gym.academyproject.InterfaceAdaptors.exception.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador web responsavel pelos endpoints referentes a usuario
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * /user/add
     * endpoint que recebe um Usuario e adiciona ele no sistema
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) throws Exception {
        try {
            userService.add(user);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        }catch (ProjectException e){
            throw new ProjectException(e.getMessage());
        }
    }
    /**
     * /user/delete/{id}
     * endpoint que recebe um id de usuario e remove do sistema
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws Exception  {
        try {
            userService.remove(id);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Usuário removido com sucesso.");

        }catch (ProjectException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    /**
     * /user/list
     * endpoint que mostra todos os usuarios cadastrados
     */
    @GetMapping("/list")
    public List<User>  showUserList() {
        return userService.list();
    }
    /**
     * /user/profile/id
     * endpoint que leva ao perfil do usuario
     */
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> userProfile(@PathVariable Integer id) {
        try {
            var user = userService.getUserById(id);

            if(user != null){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(user);
            }else{
                throw new ProjectException("Não foi possível encontrar o usuário.");
            }
        }catch (ProjectException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}