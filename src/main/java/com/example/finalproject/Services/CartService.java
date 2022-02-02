package com.example.finalproject.Services;

import com.example.finalproject.Entities.Cart;

public interface CartService {
    public Cart getCart(int user_id);
    public Cart addCart(int user_id,Cart cart);
    public void deleteCart(int cart_id);
}
