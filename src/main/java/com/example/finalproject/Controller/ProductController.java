package com.example.finalproject.Controller;

import com.example.finalproject.Entities.Product;
import com.example.finalproject.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.ACCEPTED);
    }

    @PostMapping( value = "/{id}", consumes = "application/json")
    public ResponseEntity<Product> createProduct(@PathVariable String id, @RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(Integer.parseInt(id), product), HttpStatus.CREATED);
    }
}
