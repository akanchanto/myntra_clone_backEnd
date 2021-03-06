package com.example.finalproject.Services;

import com.example.finalproject.Entities.User;
import com.example.finalproject.Exceptions.ResourceNotFoundException;
import com.example.finalproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Lazy
@Service
public class UserServiceImplement implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        User user  = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        User u = userRepository.findById(id).get();
        user.setId(u.getId());
        userRepository.save(user); //updated
        return user;
    }

    @Override
    public User deleteUser(int id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User createUser(User user) {
//        users.add(user);
        userRepository.save(user);
        return  user;
    }
}
