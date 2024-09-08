package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
    @Query("SELECT a FROM Assignee a WHERE a.department.id = :departmentId")
    List<Assignee> findByDepartmentId(@Param("departmentId") Long departmentId);

}
