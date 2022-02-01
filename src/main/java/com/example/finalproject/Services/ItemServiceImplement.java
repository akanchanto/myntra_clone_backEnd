package com.example.finalproject.Services;

import com.example.finalproject.Entities.Cart;
import com.example.finalproject.Entities.Extra;
import com.example.finalproject.Entities.Item;
import com.example.finalproject.Repositories.CartRepository;
import com.example.finalproject.Repositories.ExtraRepository;
import com.example.finalproject.Repositories.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemServiceImplement implements ItemService {

    private ItemRepository itemRepository;
    private CartRepository cartRepository;
    private ExtraRepository extraRepository;

    @Autowired
    public ItemServiceImplement(ItemRepository itemRepository,CartRepository cartRepository,ExtraRepository extraRepository){
        this.itemRepository = itemRepository;
        this.cartRepository=cartRepository;
        this.extraRepository=extraRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> byId = itemRepository.findById(id);
        return byId.get();
    }

    @Override
    public Item addItem(int cart_id, int extra_id, Item item) {
        Optional<Cart> optCart = cartRepository.findById(cart_id);
        Cart cart = optCart.get();
        Optional<Extra> optExtra = extraRepository.findById(extra_id);
        Extra extra = optExtra.get();
        item.setExtra(extra);
        item.setCart(cart);
        List<Item> items = cart.getItems();
        items.add(item);
        cart.setItems(items);
        cartRepository.save(cart);
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(int id, Map<String, Object> fields) {
        Optional<Item> tempItem = itemRepository.findById(id);
        Item item = tempItem.get();
        fields.forEach((k,v)->{
            Field field = ReflectionUtils.findField(Item.class,k);
            field.setAccessible(true);
            ReflectionUtils.setField(field,item,v);
        });
        return  itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
