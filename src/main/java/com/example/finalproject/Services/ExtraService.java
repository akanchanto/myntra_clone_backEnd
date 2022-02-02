package com.example.finalproject.Services;

import com.example.finalproject.Entities.Extra;
import com.example.finalproject.Entities.Product;

public interface ExtraService {
    public Product updateExtra(int userId, int productId, int extraId, Extra extra);
    public Product addExtra(int userId, int productId, Extra extra);
    public Product deleteExtra(int userId, int productId, int extraId);
}
