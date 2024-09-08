package com.example.GrievanceManagement.Service;

import com.example.GrievanceManagement.entity.Assignee;
import com.example.GrievanceManagement.entity.Department;
import com.example.GrievanceManagement.entity.Supervisor;
import com.example.GrievanceManagement.repository.DepartmentRepository;
import com.example.GrievanceManagement.repository.AssigneeRepository;
import com.example.GrievanceManagement.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AssigneeRepository assigneeRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Assignee> getAllAssigneesFromDepartment(Long departmentId) {

        return assigneeRepository.findByDepartmentId(departmentId);
    }

    public List<Supervisor> getAllSupervisorsFromDepartment(Long departmentId) {

        return supervisorRepository.findByDepartmentId(departmentId);
    }
}
