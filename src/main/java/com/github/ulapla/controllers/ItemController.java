package com.github.ulapla.controllers;

import com.github.ulapla.model.Category;
import com.github.ulapla.model.Item;
import com.github.ulapla.model.ItemLocation;
import com.github.ulapla.model.Location;
import com.github.ulapla.security.CurrentUser;
import com.github.ulapla.service.CategoryService;
import com.github.ulapla.service.ItemLocationService;
import com.github.ulapla.service.ItemService;
import com.github.ulapla.service.LocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public List<Location> locations(@AuthenticationPrincipal CurrentUser customUser) {
        return locationService.findAll(customUser.getUser().getId());
    }

    @ModelAttribute("categories")
    public List<Category> categories(@AuthenticationPrincipal CurrentUser customUser) {
        return categoryService.findAll(customUser.getUser().getId());
    }

    @GetMapping("/all")
    public String printItems(Model model, Pageable pageable, @AuthenticationPrincipal CurrentUser customUser) {
        Page<Item> page = itemService.findAll(pageable, customUser.getUser().getId());
        model.addAttribute("page", page);
        return "item/all_item";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "item/add_item";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(@Valid Item item, BindingResult result,
                              @AuthenticationPrincipal CurrentUser customUser) {
        if (result.hasErrors()) {
            return "item/add_item";
        }
        item.setUserId(customUser.getUser().getId());
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
        return "redirect:/api/item/show/" +item.getId();
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
                         Model model,
                         @AuthenticationPrincipal CurrentUser customUser,
                         Pageable pageable) {

        if (categoryId != null) {
            model.addAttribute("page", itemService.findByCategory(
                    categoryService.findById(categoryId),pageable,customUser.getUser().getId()));
        }
        else if (!name.equals("")) {
            Page<Item> page = itemService.findByName(name, pageable,customUser.getUser().getId());
            model.addAttribute("page", page);
        }
        else if(!description.equals("")){
            model.addAttribute("page",itemService.findByDescription(description, pageable, customUser.getUser().getId()));
        }
        return "item/all_item";
    }

    @GetMapping("/show/{id}")
    public String showItemLocations(Model model,@PathVariable Long id){
        model.addAttribute("item", itemService.findById(id));
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
        return "redirect:/api/item/show/" + itemLocation.getItem().getId();
    }

    @GetMapping("/location/delete/{id}")
    public String deleteItemLocation(@PathVariable Long id){

        ItemLocation itemLocation = itemLocationService.findById(id);
        itemLocationService.deleteItemLocation(itemLocation);
        return "redirect:/api/item/show/"+itemLocation.getItem().getId();
    }

    @PostMapping("/quick/sub")
    public String subtractQuantity(@RequestParam Long itemLocationId, @RequestParam int usedQuantity){
        ItemLocation itemLocation = itemLocationService.findById(itemLocationId);
        int newQuantity = itemLocation.getQuantity() - usedQuantity;
        itemLocation.setQuantity(newQuantity);
        itemLocationService.saveItemLocation(itemLocation);
        return "redirect:/api/item/show/"+itemLocation.getItem().getId();
    }
}
