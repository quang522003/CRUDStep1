package com.example.category_management_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id 
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "name")
    private String categoryName;
    @Column(name = "created_at")
    private LocalDateTime categoryCreateAt;

    public Category(){
        this.categoryCreateAt = LocalDateTime.now();
    }
    public Category(String categoryName){
        this.categoryName = categoryName;
    }
    public Category(Integer categoryId){
        this.categoryId = categoryId;
    }
    

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public Category fromCategoryName(String CategoryName){
        Category category = new Category();
        category.setCategoryName(CategoryName);
        return category;
    }

    public Integer getCategoryId(){
        return this.categoryId;
    }

    public void setCategoryId(int id){
        this.categoryId = id;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    public void setCategoryName(String name){
        this.categoryName = name;
    }

    public LocalDateTime getCategoryCreatedAt() {
        return categoryCreateAt;
    }

    public void setCategoryCreatedAt(LocalDateTime createdAt) {
        this.categoryCreateAt = createdAt;
    }
}
