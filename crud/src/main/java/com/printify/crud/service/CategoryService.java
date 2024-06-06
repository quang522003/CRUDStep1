package com.printify.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.printify.crud.entity.Category;
import com.printify.crud.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        return category;
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id) ;
    }
    

    public Category updateCategory(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Optional<Category> deleteCategory(int id){
        Optional<Category> categoryDeleted = categoryRepository.findById(id);
        categoryRepository.deleteById(id);
        return categoryDeleted;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}