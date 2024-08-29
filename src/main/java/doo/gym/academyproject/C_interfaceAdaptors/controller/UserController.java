package doo.gym.academyproject.C_interfaceAdaptors.controller;


import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.service.interfaces.UserService;
import doo.gym.academyproject.C_interfaceAdaptors.exception.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @GetMapping("/list")
    public List<User>  showUserList() {
        return userService.list();
    }

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