package com.example.finalproject.Services;

import com.example.finalproject.Entities.Product;
import com.example.finalproject.Entities.User;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public Product getProduct(int id);
    public Product updateProduct(int id, Product product);
    public void deleteProduct(int id);
    public Product createProduct(int id, Product product);
}
