package com.github.ulapla.controllers;

import com.github.ulapla.model.Category;
import com.github.ulapla.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Controller
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String allCategories(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/all_category";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return"category/add_category";
    }

    @PostMapping("/add")
    public String saveCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/api/category/all";
    }


}
