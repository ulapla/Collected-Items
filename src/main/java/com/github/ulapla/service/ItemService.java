package com.github.ulapla.service;

import com.github.ulapla.dto.ItemDto;
import com.github.ulapla.model.Item;
import com.github.ulapla.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> findAll(){
        return itemRepository.findAll().stream()
                .map(ItemDto::new)
                .collect(Collectors.toList());
    }

    public void createItem(ItemDto itemDto){
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setType(itemDto.getType());
        //item.setLocations();
        item.setDescription(itemDto.getDescription());
        item.setQuantity(itemDto.getQuantity());
        item.setFilePath(itemDto.getFilePath());
        itemRepository.save(item);
    }
}
