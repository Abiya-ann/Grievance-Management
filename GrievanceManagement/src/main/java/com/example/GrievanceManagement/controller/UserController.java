package com.example.GrievanceManagement.controller;

import com.example.GrievanceManagement.Service.UserService;
import com.example.GrievanceManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
        public ResponseEntity<User>createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user) ;
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List <User>>getAllUsers(){
         List<User> users= userService.getAllUsers();
         return ResponseEntity.ok(users);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user= userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {

            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();

    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

}

