package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.Assignee;
import com.example.GrievanceManagement.entity.Department;
import com.example.GrievanceManagement.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}


