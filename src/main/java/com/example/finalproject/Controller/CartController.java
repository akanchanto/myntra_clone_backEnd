package com.example.finalproject.Controller;

import com.example.finalproject.Entities.Cart;
import com.example.finalproject.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable int id){
        return cartService.getCart(id);
    }

    @PostMapping("/{id}")
    public Cart createCart(@PathVariable int id,@RequestBody Cart cart){
        return cartService.addCart(id,cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable int id){
        cartService.deleteCart(id);
        return "Cart deleted successfully";
    }
}
