package com.github.ulapla.controllers;

import com.github.ulapla.model.Item;
import com.github.ulapla.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String redirectToHome(){
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String mainPage(Model model){
        if(itemService.findAll().isEmpty()){
            model.addAttribute("quantityAll",0);
        }else {
            model.addAttribute("quantityAll", itemService.countAllItems());
        }
        return "home";
    }
}
