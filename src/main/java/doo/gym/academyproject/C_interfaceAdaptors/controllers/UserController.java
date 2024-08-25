package doo.gym.academyproject.C_interfaceAdaptors.controllers;


import doo.gym.academyproject.A_entity.User;
import doo.gym.academyproject.B_useCases.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/list")
    public List<User>  showUserList() {
        return userService.list();
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> userProfile(@PathVariable Integer id) {
        var user = userService.getUserById(id);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.ok(new Object() {
            public String errorMessage = " Não foi possível encontrar o usuário.";
        }); // temporario // resolver dps
    }


}