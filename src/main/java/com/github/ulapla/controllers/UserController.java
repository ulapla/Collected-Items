package com.github.ulapla.controllers;

import com.github.ulapla.model.User;
import com.github.ulapla.security.CurrentUser;
import com.github.ulapla.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/create/user")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/create";
    }

    @PostMapping("/create/user")
    public String saveUser(User user){
        User us = new User();
        us.setPassword(user.getPassword());
        us.setUsername(user.getUsername());
        us.setEnabled(1);
        userService.saveUser(us);
        return "redirect:/api/home";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

}
