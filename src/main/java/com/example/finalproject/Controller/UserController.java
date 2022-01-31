package com.example.finalproject.Controller;

import com.example.finalproject.Entities.User;
import com.example.finalproject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return this.userService.getUser(Integer.parseInt(userId));
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}", consumes = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable String userId){
        return this.userService.updateUser(Integer.parseInt(userId), user);
    }

}
