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
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
//        User user = this.userService.getUser(Integer.parseInt(userId));
        return new ResponseEntity<>(this.userService.getUser(Integer.parseInt(userId)),
                HttpStatus.ACCEPTED);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}", consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId){
        return new ResponseEntity<>(this.userService.updateUser(Integer.parseInt(userId), user)
                , HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(this.userService.deleteUser(Integer.parseInt(userId)),
                HttpStatus.ACCEPTED);
    }

}
