package com.example.finalproject.Services;

import com.example.finalproject.Entities.Product;
import com.example.finalproject.Entities.User;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public Product getProduct(int id);
    public Product updateProduct(int id, Product product);
    public Product deleteProduct(int id);
    public Product createProduct(Product product);
}
