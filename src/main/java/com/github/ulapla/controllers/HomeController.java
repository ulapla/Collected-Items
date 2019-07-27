package com.github.ulapla.controllers;

import com.github.ulapla.security.CurrentUser;
import com.github.ulapla.model.User;
import com.github.ulapla.service.ItemService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String landingPage(){
        return "landing-page";
    }
    @GetMapping("/api/home")
    public String mainPage(Model model,@AuthenticationPrincipal CurrentUser customUser){
        User entityUser = customUser.getUser();
        model.addAttribute("user",entityUser);
        if(itemService.findAll(customUser.getUser().getId()).isEmpty()){
            model.addAttribute("quantityAll",0);
        }else {
            model.addAttribute("quantityAll", itemService.countAllItems());
        }
        return "home";
    }
}
