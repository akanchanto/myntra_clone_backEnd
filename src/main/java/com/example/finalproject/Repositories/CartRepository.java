package com.example.finalproject.Repositories;

import com.example.finalproject.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
