package com.printify.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printify.crud.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String name);
    
} 
