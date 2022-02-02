package com.example.finalproject.Services;

import com.example.finalproject.Entities.Extra;
import com.example.finalproject.Entities.Product;
import com.example.finalproject.Repositories.ExtraRepository;
import com.example.finalproject.Repositories.ProductRepository;
import com.example.finalproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraServiceImplement implements ExtraService{
    ProductRepository productRepository;
    ExtraRepository extraRepository;
    UserRepository userRepository;

    @Autowired
    public ExtraServiceImplement(ProductRepository productRepository, ExtraRepository extraRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.extraRepository = extraRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product updateExtra(int userId, int productId, int extraId, Extra extra) {
        Product product = productRepository.findById(productId).get();
        Extra e = extraRepository.findById(extraId).get();
        if(product.getSeller().getId() != userId || e.getProduct().getId() != productId)
            return  null;
        else {
            extra.setId(extraId);
            extraRepository.save(extra);
            return product;
        }
    }

    @Override
    public Product addExtra(int userId, int productId, Extra extra) {
        Product product = productRepository.findById(productId).get();
        if(product.getSeller().getId() != userId)
            return  null;
        else{
            extra.setProduct(product);
            extraRepository.save(extra);
            List<Extra> extras = product.getExtras();
            extras.add(extra);
            productRepository.save(product);
            return product;
        }
    }

    @Override
    public Product deleteExtra(int userId, int productId, int extraId) {
        Product product = productRepository.findById(productId).get();
        Extra e = extraRepository.findById(extraId).get();
        if(product.getSeller().getId() != userId || e.getProduct().getId() != productId)
            return  null;
        else{
            extraRepository.deleteById(extraId);
            return product;
        }
    }
}
