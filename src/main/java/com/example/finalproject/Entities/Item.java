package com.example.finalproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="quantity")
    private int quantity;


    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;


    @OneToOne
    @JoinColumn(name="extra_id")
    private Extra extra;

    public Item() {
    }

    public Item(int quantity, Extra extra) {
        this.quantity = quantity;
        this.extra = extra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
