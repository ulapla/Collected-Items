package com.github.ulapla.controllers;

import com.github.ulapla.model.Category;
import com.github.ulapla.security.CurrentUser;
import com.github.ulapla.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String allCategories(Model model,@AuthenticationPrincipal CurrentUser customUser){
        model.addAttribute("categories",categoryService.findAll(customUser.getUser().getId()));
        return "category/all_category";
    }

    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return"category/add_category";
    }

    @PostMapping("/add")
    public String saveCategory(@Valid Category category, BindingResult result,
                               @AuthenticationPrincipal CurrentUser customUser){
        if (result.hasErrors()) {
            return"category/add_category";
        }
        category.setUserId(customUser.getUser().getId());
        categoryService.saveCategory(category);
        return "redirect:/api/category/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "redirect:/api/category/all";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(Model model, @PathVariable Long id){
        model.addAttribute("category",categoryService.findById(id));
        return"category/edit_category";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()) {
            return"category/edit_category";
        }
        categoryService.saveCategory(category);
        return "redirect:/api/category/all";
    }

}
