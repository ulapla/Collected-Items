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
import java.util.List;

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
        return "item/all_item";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "item/add_item";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(Model model, @Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "item/add_item";
        }
        itemService.saveItem(item);
        return "redirect:/api/item/" + item.getId() + "/add/location";
    }

    @GetMapping("{id}/add/location")
    public String addLocationToItem(Model model, @PathVariable Long id) {
        model.addAttribute("item", itemService.findById(id));
        model.addAttribute("itemLocation", new ItemLocation());
        return "item/add_location";
    }

    @PostMapping("/add/location")
    public String saveLocation(@Valid ItemLocation itemLocation,BindingResult result) {
        if (result.hasErrors()) {
            return "item/add_location";
        }
        ItemLocation newItemLocation = new ItemLocation();
        newItemLocation.setQuantity(itemLocation.getQuantity());
        newItemLocation.setLocation(itemLocation.getLocation());
        newItemLocation.setItem(itemService.findById(itemLocation.getItem().getId()));
        itemLocationService.saveItemLocation(newItemLocation);
        return "redirect:/api/item/add";
    }

    @GetMapping("edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "item/edit_item";
    }

    @PostMapping("/edit/{id}")
    public String saveItem(@Valid Item item,BindingResult result) {
        if (result.hasErrors()) {
            return "item/edit_item";
        }
        itemService.saveItem(item);
        return "redirect:/api/item/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/api/item/all";
    }


    @PostMapping("/search")

    public String search(@RequestParam String name,
                         @RequestParam(required = false) Long categoryId,
                         @RequestParam String description,
                         Model model) {

        if (categoryId != null) {
            model.addAttribute("items", itemService.findByCategory(categoryService.findById(categoryId)));
        }
        else if (!name.equals("")) {
            model.addAttribute("items", itemService.findByName(name));
        }
        else if(!description.equals("")){
            model.addAttribute("items",itemService.findByDescription(description));
        }
        return "item/all_item";
    }

    @GetMapping("/show/locations/{id}")
    public String showItemLocations(Model model,@PathVariable Long id){
        model.addAttribute("itemLocations", itemService.findById(id).getItemLocations());
        return "item/item_location";
    }

    @GetMapping("/location/edit/{id}")
    public String editQuantity(Model model, @PathVariable Long id){
        model.addAttribute("itemLocation", itemLocationService.findById(id));
        return "item/edit_quantity";
    }

    @PostMapping("/location/edit/{id}")
    public String saveQuantity(@Valid ItemLocation itemLocation, BindingResult result){
        if (result.hasErrors()) {
            return "item/edit_quantity";
        }
        itemLocationService.saveItemLocation(itemLocation);
        return "redirect:/api/item/show/locations/" + itemLocation.getItem().getId();
    }

    @GetMapping("/location/delete/{id}")
    public String deleteItemLocation(@PathVariable Long id){

        itemLocationService.findById(id).getItem().getId();
        ItemLocation itemLocation = itemLocationService.findById(id);
        itemLocationService.deleteItemLocation(itemLocationService.findById(id));
        return "redirect:/api/item/show/locations/"+itemLocationService.findById(id).getItem().getId();
    }
}
