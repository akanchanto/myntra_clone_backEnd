package com.example.finalproject.Services;

import com.example.finalproject.Entities.Product;
import com.example.finalproject.Entities.User;
import com.example.finalproject.Repositories.ProductRepository;
import com.example.finalproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImplement implements ProductService{
    ProductRepository productRepository;
    UserRepository userRepository;

    @Autowired
    public ProductServiceImplement(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product createProduct(int id, Product product) {
        User user = userRepository.findById(id).get();
        product.setSeller(user);
        productRepository.save(product);
        List<Product> products = user.getProducts();
        products.add(product);
        userRepository.save(user);
        return  product;
    }
}
