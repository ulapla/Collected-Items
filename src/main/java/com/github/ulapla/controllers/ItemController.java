package com.github.ulapla.controllers;

import com.github.ulapla.dto.ItemDto;
import com.github.ulapla.dto.LocationDto;
import com.github.ulapla.service.ItemService;
import com.github.ulapla.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;
    private LocationService locationService;

    @Autowired
    public ItemController(ItemService itemService, LocationService locationService) {
        this.itemService = itemService;
        this.locationService = locationService;
    }

    @GetMapping("/get/all")
    @ResponseBody
    public List<ItemDto> allItems(){
        return itemService.findAll();
    }

    @GetMapping("/all")
    public String printItems(Model model){
        model.addAttribute("items", itemService.findAll());
        return "all_item";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("itemDto",new ItemDto());
        return "add_item";
    }

    @ModelAttribute("locations")
    public List<LocationDto> locations(){
        return locationService.findAll();
    }

    @PostMapping("/add")
    public String createItem(@RequestBody ItemDto itemDto){
        itemService.createItem(itemDto);
        return "redirect:/api/item/all";
    }
}
