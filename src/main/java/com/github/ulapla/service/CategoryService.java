package com.github.ulapla.service;

import com.github.ulapla.model.Category;
import com.github.ulapla.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
}
