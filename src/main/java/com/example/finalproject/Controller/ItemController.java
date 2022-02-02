package com.example.finalproject.Controller;

import com.example.finalproject.Entities.Item;
import com.example.finalproject.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @PostMapping("/cart/{cart_id}/extra/{extra_id}")
    public Item addItem(@PathVariable int cart_id,@PathVariable int extra_id,@RequestBody Item item){
        System.out.println(item);
        return itemService.addItem(cart_id,extra_id,item);
    }

    @PatchMapping("/{id}")
    public Item updateItem(@PathVariable int id,@RequestBody Map<String,Object> fields){
        System.out.println(fields);
        return itemService.updateItem(id,fields);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id){
        itemService.deleteItem(id);
        return "Item deleted Successfully";
    }
}
