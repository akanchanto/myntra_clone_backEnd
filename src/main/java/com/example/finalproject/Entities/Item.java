package com.example.finalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Column")
    private int quantity;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="order_detail_id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
