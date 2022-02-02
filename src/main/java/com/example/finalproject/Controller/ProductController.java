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
        List<Product> products = productService.getAllProduct();
        return products != null ?
                new ResponseEntity<>(products, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping( value = "/{id}", consumes = "application/json")
    public ResponseEntity<Product> createProduct(@PathVariable String id,
                                                 @RequestBody Product product){
        Product p = productService.createProduct(Integer.parseInt(id), product);
        return p != null ?
                new ResponseEntity<>(p, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{productId}", consumes = "application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,
                                                 @RequestBody Product product){
        Product p = productService.updateProduct(Integer.parseInt(id), product);
        return p != null ?
                new ResponseEntity<>(p, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        Product product = productService.getProduct(Integer.parseInt(id));
        return product!=null ?
                new ResponseEntity<>(product, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String id){
        Product product = productService.deleteProduct(Integer.parseInt(id));
        return product!=null ?
                new ResponseEntity<>(product, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
