package com.example.finalproject.Services;

import com.example.finalproject.Entities.User;

import java.util.List;


public interface UserService {

    public List<User> getAllUser();
    public User getUser(int id);
    public User updateUser(int id);
    public User deleteUser(int id);
    public User createUser();
}
