package com.example.finalproject.Controller;

import com.example.finalproject.Entities.Extra;
import com.example.finalproject.Entities.Product;
import com.example.finalproject.Services.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/products/{productId}/extras/")
public class ExtraController {
    ExtraService extraService;

    @Autowired
    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @PutMapping("/{extraId}")
    public ResponseEntity<Product> updateExtra(@PathVariable String userId,
                                               @PathVariable String productId,
                                               @PathVariable String extraId,
                                               @RequestBody Extra extra){
        Product product = extraService.updateExtra(Integer.parseInt(userId),
                                                    Integer.parseInt(productId),
                                                    Integer.parseInt(extraId),
                                                    extra);
        return product != null ?
                new ResponseEntity<>(product, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Product> addExtra(@PathVariable String userId,
                                            @PathVariable String productId,
                                            @RequestBody Extra extra){
        Product product = extraService.addExtra(
                Integer.parseInt(userId), Integer.parseInt(productId), extra);
        return product != null ?
                new ResponseEntity<>(product, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{extraId}")
    public ResponseEntity<Product> deleteExtra(@PathVariable String userId,
                                               @PathVariable String productId,
                                               @PathVariable String extraId){
        Product product = extraService.deleteExtra(Integer.parseInt(userId), Integer.parseInt(productId), Integer.parseInt(extraId));
        return product != null ?
                new ResponseEntity<>(product, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
