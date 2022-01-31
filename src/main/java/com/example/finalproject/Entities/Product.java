package com.example.finalproject.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    enum Category{
        TSHIRT,
        SHIRT,
        JEANS,
        JACKET
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="seller_id")
    private User seller;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<Extra> extras;

    public Product() {
    }

    public Product(String name, String brand, Category category, User seller) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.seller = seller;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
}
