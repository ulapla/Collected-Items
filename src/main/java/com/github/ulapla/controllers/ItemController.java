package com.github.ulapla.controllers;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import com.github.ulapla.model.Location;
import com.github.ulapla.service.CategoryService;
import com.github.ulapla.service.ItemService;
import com.github.ulapla.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/item")
public class ItemController {

    private ItemService itemService;
    private LocationService locationService;
    private CategoryService categoryService;

    public ItemController(ItemService itemService, LocationService locationService, CategoryService categoryService) {
        this.itemService = itemService;
        this.locationService = locationService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("locations")
    public List<Location> locations(){
        return  locationService.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/all")
    public String printItems(Model model){
        model.addAttribute("items", itemService.findAll());
        return "all_item";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("item",new Item());
        return "add_item";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(Model model, @Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "add_item";
        }
        itemService.saveItem(item);
        return "redirect:/api/item/add";
    }
}
