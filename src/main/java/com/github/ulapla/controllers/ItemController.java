package com.github.ulapla.controllers;

import com.github.ulapla.dto.ItemDto;
import com.github.ulapla.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String addItem(Model model){

        return "add_item";
    }

    @PostMapping("/add")
    public String createItem(@RequestBody ItemDto itemDto){
        itemService.createItem(itemDto);
        return "add_item";
    }
}
