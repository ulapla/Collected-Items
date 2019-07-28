package com.github.ulapla.service;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.ItemLocation;
import com.github.ulapla.repository.ItemLocationRepository;
import com.github.ulapla.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemLocationService {

    private ItemLocationRepository itemLocationRepository;
    private final ItemRepository itemRepository;

    public ItemLocationService(ItemLocationRepository itemLocationRepository, ItemRepository itemRepository) {
        this.itemLocationRepository = itemLocationRepository;
        this.itemRepository = itemRepository;
    }


    public void saveItemLocation(ItemLocation itemLocation){
        itemLocationRepository.save(itemLocation);
        Item item = itemLocation.getItem();
        item.setQuantity(countItemQuantity(item));
        itemRepository.save(item);
    }

    public ItemLocation findById(Long id){
        return itemLocationRepository.findById(id).get();
    }

    public void deleteItemLocation(ItemLocation itemLocation){
        Item item = itemLocation.getItem();
        itemLocationRepository.delete(itemLocation);
        item.setQuantity(countItemQuantity(item));
        itemRepository.save(item);
    }

    public int countItemQuantity(Item item){
        int quantity = 0;
        if(item.getItemLocations().size() == 1){
            quantity = item.getItemLocations().iterator().next().getQuantity();
        }
        else if (item.getItemLocations().size() > 1) {
            quantity = itemLocationRepository.sumItemQuantityFromLocations(item);
        }
        return quantity;
    }
}
