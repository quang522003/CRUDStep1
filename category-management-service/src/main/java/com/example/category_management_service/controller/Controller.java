package com.example.category_management_service.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.category_management_service.dto.CategoryRequestDTO;
import com.example.category_management_service.entity.Category;
import com.example.category_management_service.exception.ResourceNotFound;
import com.example.category_management_service.service.CategoryService;
import com.example.category_management_service.service.CustomHealthIndicator;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1")
public class Controller {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomHealthIndicator customHealthIndicator;
    private Logger logger = LogManager.getLogger(Controller.class);

    //CRUD categories
    @CrossOrigin
    @GetMapping("/categories")
    public ResponseEntity<Object> getAll() {
        try{
            List<Category> category = categoryService.getAll();
            logger.info("Get all Category: " + category.size());
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
        catch(DataAccessException e){ //lỗi truy cập 
            logger.error("Loi truy cap");
            ResourceNotFound error = new ResourceNotFound("Lỗi truy cập");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @CrossOrigin
    @GetMapping("/categories/{id}.json")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
        try{
            if(categoryService.getCategoryById(id).isPresent()){
                logger.info("Read category "+id+ " OK");
                return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.valueOf(200));
            }
            else{
                logger.error("Read category "+ id + " Fail");
                return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
            }
        }
        catch(DataAccessException e){ //lỗi truy cập 
            logger.error("Loi truy cap");
            ResourceNotFound error = new ResourceNotFound("Lỗi truy cập");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        } 
        
    }

    @CrossOrigin
    @PostMapping("/categories.json") // Thêm chỉ với trường categoryName
    public ResponseEntity<Object> addCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        try{
            Category categoryResponse = categoryService.addCategory(categoryRequestDTO.getCategoryName());
            logger.info("Create category:  " + categoryResponse.getCategoryName());
            return new ResponseEntity<>(categoryResponse,HttpStatus.valueOf(201));       
        }catch(DataAccessException e){ //lỗi truy cập 
            logger.error("Loi truy cap");
            ResourceNotFound error = new ResourceNotFound("Lỗi truy cập");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        } 
        
    }

    @CrossOrigin
    @PutMapping("/categories/{id}.json")
    public ResponseEntity<Object> updateCategory(@RequestBody CategoryRequestDTO categoryRequestDTO,@PathVariable Integer id) { 
        try{
            Optional<Category> category = categoryService.getCategoryById(id);
            if(category.isEmpty()){
                logger.error("Update category:" + id + " Fail");
                throw new ResourceNotFound("");
            }
            else{
                Category categoryResponse = category.get();
                categoryResponse.setCategoryName(categoryRequestDTO.getCategoryName());
                categoryResponse = categoryService.updateCategory(categoryResponse);
                logger.info("Update category:" + id + ": " + categoryRequestDTO.getCategoryName());
                return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
            }
        }catch(DataAccessException e){ //lỗi truy cập 
            logger.error("Loi truy cap");
            ResourceNotFound error = new ResourceNotFound("Lỗi truy cập");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }catch (ResourceNotFound e){ // lỗi không thấy bản ghi 
            return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
        }     
    }

    @CrossOrigin
    @DeleteMapping("/categories/{id}.json")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id) {
        try{
            categoryService.deleteCategory(id);
            logger.warn("Delete category " + id);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
        }catch(DataAccessException e){ //lỗi truy cập 
            logger.error("Loi truy cap");
            ResourceNotFound error = new ResourceNotFound("Lỗi truy cập");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    
    }


    @CrossOrigin
    @GetMapping("/health")
    public ResponseEntity<Object> checkHealthService() {
        Health health  = customHealthIndicator.health();
        if(health.getStatus().equals(Status.UP)){
            return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyMap());
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyMap());
        }
    }
    
}
