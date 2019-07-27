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

    public List<Category> findAll(Long userId){
        return categoryRepository.findAllByUserId(userId);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.delete(categoryRepository.findById(id).get());
    }
}
