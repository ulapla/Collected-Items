package com.github.ulapla.controllers;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import com.github.ulapla.model.ItemLocation;
import com.github.ulapla.model.Location;
import com.github.ulapla.service.CategoryService;
import com.github.ulapla.service.ItemLocationService;
import com.github.ulapla.service.ItemService;
import com.github.ulapla.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;
    private LocationService locationService;
    private CategoryService categoryService;
    private ItemLocationService itemLocationService;

    public ItemController(ItemService itemService, LocationService locationService, CategoryService categoryService, ItemLocationService itemLocationService) {
        this.itemService = itemService;
        this.locationService = locationService;
        this.categoryService = categoryService;
        this.itemLocationService = itemLocationService;
    }

    @ModelAttribute("locations")
    public List<Location> locations() {
        return locationService.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/all")
    public String printItems(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "all_item";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "add_item";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(Model model, @Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "add_item";
        }
        itemService.saveItem(item);
        return "redirect:/api/item/" + item.getId() + "/add/location";
    }

    @GetMapping("{id}/add/location")
    public String addLocationToItem(Model model, @PathVariable Long id) {
        model.addAttribute("item", itemService.findById(id));
        model.addAttribute("itemLocation", new ItemLocation());
        return "add_location";
    }

    @PostMapping("{id}/add/location")
    public String saveLocation(ItemLocation itemLocation, Long id) {
        itemLocationService.saveItemLocation(itemLocation);
        return "redirect:/api/item/add";
    }

    @GetMapping("edit/{id}")
    public String editItem(@PathVariable Long id, Model model){
        return"edit_item";
    }
}
