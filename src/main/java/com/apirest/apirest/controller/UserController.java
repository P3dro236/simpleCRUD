package com.apirest.apirest.controller;

import com.apirest.apirest.model.User;
import com.apirest.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/{id}")
    public User updateUserEmail(@PathVariable Integer id, @RequestParam String newEmail){
        return userService.updateEmail(id, newEmail);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "Usuario deletado com sucesso";
    }
}
