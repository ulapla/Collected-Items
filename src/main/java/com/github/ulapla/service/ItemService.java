package com.github.ulapla.service;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import com.github.ulapla.repository.CategoryRepository;
import com.github.ulapla.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Item> findAll(Long userId){
        return itemRepository.findAllByUserId(userId);
    }

    public Page<Item> findByCategory(Category category, Pageable pageable, Long userId){
        return itemRepository.findByCategoryAndUserId(category, pageable, userId);
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

    public Page<Item> findByName(String name, Pageable pageable, Long userId){
        return itemRepository.findByNameContainingAndUserId(name, pageable,userId);
    }

    public Page<Item>findByDescription(String s, Pageable pageable, Long userId){
        return itemRepository.findByDescriptionContainingAndUserId(s,pageable, userId);
    }

    public Page<Item> findAll(Pageable pageable, Long userId){
       return itemRepository.findAllByUserId(pageable,userId);
    }

    public int countAllItems(Long userId){
        return itemRepository.allItemsSum(userId);
    }

}
