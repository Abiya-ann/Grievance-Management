package com.example.GrievanceManagement.Service;

import com.example.GrievanceManagement.entity.Assignee;

import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.repository.AssigneeRepository;
import com.example.GrievanceManagement.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssigneeService {
    private final AssigneeRepository assigneeRepository;
    private final GrievanceRepository grievanceRepository;
    @Autowired
    public AssigneeService(AssigneeRepository assigneeRepository, GrievanceRepository grievanceRepository){
        this.assigneeRepository = assigneeRepository;
        this.grievanceRepository =grievanceRepository;
    }

    public Assignee saveAssignee(Assignee assignee){
        return assigneeRepository.save(assignee);
    }

    public List<Assignee> getAllAssignee(){
        return assigneeRepository.findAll();
    }
    public Optional<Assignee> getAssigneeById(Long assigneeId) {
        return assigneeRepository.findById(assigneeId);
    }
    public void deleteAssignee(Long assigneeId){
        assigneeRepository.deleteById(assigneeId);
    }

    public Assignee updateAssignee(Long assigneeId, Assignee assigneeDetails) {
        Assignee assignee = assigneeRepository.findById(assigneeId).orElseThrow(() -> new RuntimeException("Assignee not found"));
        assignee.setAssigneeName(assigneeDetails.getAssigneeName());
        assignee.setAssigneeEmail(assigneeDetails.getAssigneeEmail());
        assignee.setAssigneePassword(assigneeDetails.getAssigneePassword());
        assignee.setRole(assigneeDetails.getRole());
        return assigneeRepository.save(assignee);
    }

    public List<Grievance> getAllGrievancesOfAnAssignee(Long assigneeId){
        Assignee assignee = assigneeRepository.findById(assigneeId).orElseThrow(()->new RuntimeException("Assignee not found"));
        return grievanceRepository.findByAssigneesId(assigneeId);
    }
    public List<Assignee> getAssigneesByGrievanceId(Long grievanceId) {
        Grievance grievance = grievanceRepository.findById(grievanceId)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
        return new ArrayList<>(grievance.getAssignees());
    }


}
