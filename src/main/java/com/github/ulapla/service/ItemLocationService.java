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
        item.setQuantity();
        itemRepository.save(item);
    }

    public ItemLocation findById(Long id){
        return itemLocationRepository.findById(id).get();
    }

    public void deleteItemLocation(ItemLocation itemLocation){
        Item item = itemLocation.getItem();
        itemLocationRepository.delete(itemLocation);
        item.setQuantity();
        itemRepository.save(item);
    }
}
