package com.example.category_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category_management_service.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String name); 
} 
