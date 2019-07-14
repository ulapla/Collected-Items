package com.github.ulapla.controllers;

import com.github.ulapla.dto.ItemDto;
import com.github.ulapla.model.Item;
import com.github.ulapla.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get/all")
    @ResponseBody
    public List<ItemDto> allItems(){
        return itemService.findAll();
    }

    @GetMapping("/all")
    public String printItems(){
        return "all_item";
    }

    @GetMapping("/add")
    public String addItem(){
        return "add_item";
    }

    @PostMapping("/add")
    public String createItem(@RequestBody ItemDto itemDto){
        itemService.createItem(itemDto);
        return "redirect:/api/item/all";
    }
}
