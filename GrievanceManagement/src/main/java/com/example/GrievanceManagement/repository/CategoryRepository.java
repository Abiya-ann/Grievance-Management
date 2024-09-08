package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c from Category c Where c.categoryName = : categoryName")
    Category findByName(@Param("String categoryName") String categoryName);
}
