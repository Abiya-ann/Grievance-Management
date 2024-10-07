package com.example.GrievanceManagement.controller;

import com.example.GrievanceManagement.Service.CategoryService;
import com.example.GrievanceManagement.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>>getAllCategories(){
        List <Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity <Void> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity <Category>getCategoryById(@PathVariable Long categoryId){
        Optional <Category> category = categoryService.getCategoryById(categoryId);
        return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId,category);
    }
    @GetMapping("/name/{categoryName}")
    public ResponseEntity <Category> getCategoryByName(@PathVariable String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
         return ResponseEntity.ok(category);
    }
    }



