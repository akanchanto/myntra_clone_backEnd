package com.example.finalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name="extra")
public class Extra {
    enum Size{
        S,M,L,XL,XXL
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name="column")
    private int quantity;

    @Column(name="price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    public Extra() {
    }

    public Extra(Size size, int quantity, double price, Product product) {
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
