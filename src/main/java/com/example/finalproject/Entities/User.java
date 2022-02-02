package com.example.finalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    enum UserType {
        BUYER,
        SELLER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    @JsonIgnoreProperties("seller")
    private List<Product> products;


    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Cart cart;

    public User() {
        // other values will be taken as random value, need to write code / method for that
        //this.userType = UserType.BUYER;
    }

    public User(String name, String passWord, String email, String address, UserType userType) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}