package com.example.finalproject.Services;

import com.example.finalproject.Entities.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    public List<Item> getAllItems();
    public Item getItemById(int id);
    public Item addItem(int cart_id, int extra_id, Item item);
    public Item updateItem(int id, Map<String,Object> fields);
    public void deleteItem(int id);
}
