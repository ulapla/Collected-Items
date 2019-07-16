package com.github.ulapla.service;

import com.github.ulapla.model.Item;
import com.github.ulapla.model.ItemLocation;
import com.github.ulapla.model.Location;
import com.github.ulapla.repository.ItemLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemLocationService {

    private ItemLocationRepository itemLocationRepository;

    @Autowired
    public ItemLocationService(ItemLocationRepository itemLocationRepository) {
        this.itemLocationRepository = itemLocationRepository;
    }

    public ItemLocation saveItemLocation(Item item, Location location, int quantity){
        ItemLocation itemLocation = new ItemLocation();
        itemLocation.setItem(item);
        itemLocation.setLocation(location);
        itemLocation.setQuantity(quantity);
        return itemLocationRepository.save(itemLocation);
    }

    public void saveItemLocation(ItemLocation itemLocation){
        itemLocationRepository.save(itemLocation);
    }
}
