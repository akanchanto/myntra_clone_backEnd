package com.example.finalproject.Services;

import com.example.finalproject.Entities.Cart;
import com.example.finalproject.Entities.Item;
import com.example.finalproject.Entities.User;
import com.example.finalproject.Repositories.CartRepository;
import com.example.finalproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService{
    private CartRepository cartRepository;
    private UserRepository userRepository;

    @Autowired
    public CartServiceImplementation(CartRepository cartRepository,UserRepository userRepository){
        this.userRepository=userRepository;
        this.cartRepository=cartRepository;
    }


    @Override
    public Cart getCart(int user_id) {
        Optional<User> tempUser = userRepository.findById(user_id);
        User user = tempUser.get();
        return user.getCart();
    }

    @Override
    public Cart addCart(int user_id,Cart cart){
        Optional<User> tempUser = userRepository.findById(user_id);
        User user = tempUser.get();
        cart.setUser(user);
        Cart tempCart = cartRepository.save(cart);
        user.setCart(tempCart);
        userRepository.save(user);
        return tempCart;
    }

    @Override
    public void deleteCart(int cart_id) {
        cartRepository.deleteById(cart_id);
    }


}
