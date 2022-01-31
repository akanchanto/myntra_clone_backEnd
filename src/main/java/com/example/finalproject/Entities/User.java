package com.example.finalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User{
    enum UserType{
        BUYER,
        SELLER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String passWord;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(){
        // other values will be taken as random value, need to write code / method for that
        this.userType = UserType.BUYER;
    }

    public User(int id, String name, String passWord, String email, String address, UserType userType) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.address = address;
        this.email = email;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}