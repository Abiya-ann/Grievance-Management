package com.example.GrievanceManagement.controller;
import com.example.GrievanceManagement.entity.Assignee;
import com.example.GrievanceManagement.entity.Department;
import com.example.GrievanceManagement.entity.Supervisor;
import com.example.GrievanceManagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private  final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity <Department> createDepartment(@RequestBody Department department){
        Department createdDepartment= departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);

    }
    @GetMapping
    public ResponseEntity <List<Department>> getAllDepartments(){
        List <Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity <Department> getDepartmentById(@PathVariable Long departmentId){
    Optional<Department> department =departmentService.getDepartmentById(departmentId);
    return department.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/assignee/{departmentId}")
    public ResponseEntity <List<Assignee>>  getAllAssigneesFromDepartment(@PathVariable Long departmentId){
        List<Assignee> assignees = departmentService.getAllAssigneesFromDepartment(departmentId);
        return ResponseEntity.ok(assignees);
    }
    @GetMapping("/supervisor/{departmentId}")
    public ResponseEntity <List<Supervisor>>  getAllSupervisorsFromDepartment(@PathVariable Long departmentId){
        List<Supervisor> supervisors = departmentService.getAllSupervisorsFromDepartment(departmentId);
        return ResponseEntity.ok(supervisors);
    }
}
