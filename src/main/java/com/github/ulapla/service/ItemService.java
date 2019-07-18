package com.github.ulapla.service;

import com.github.ulapla.dto.ItemDto;
import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import com.github.ulapla.repository.CategoryRepository;
import com.github.ulapla.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public List<Item> findByCategory(Category category){
        return itemRepository.findByCategory(category);
    }

    public void saveItem(Item item){
        if(item.getId()!=null) {
            Item item1 = itemRepository.findById(item.getId()).get();
            item.setItemLocations(item1.getItemLocations());
            item.setQuantity();
        }
        itemRepository.save(item);
    }

    public Item findById(Long id){
        return itemRepository.findById(id).get();
    }

    public void deleteItem(Long id){
        itemRepository.delete(itemRepository.findById(id).get());
    }

    public List<Item> findByName(String name){
        return itemRepository.findByNameContaining(name);
    }

    public List<Item>findByDescription(String s){
        return itemRepository.findByDescriptionContaining(s);
    }
}
