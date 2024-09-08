package com.example.GrievanceManagement.Service;


import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.Assignee;
import com.example.GrievanceManagement.entity.Supervisor;
import com.example.GrievanceManagement.repository.AssigneeRepository;
import com.example.GrievanceManagement.repository.GrievanceRepository;
import com.example.GrievanceManagement.repository.SupervisorRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {
    private final SupervisorRepository supervisorRepository;
    private final GrievanceRepository grievanceRepository;
    private final AssigneeRepository assigneeRepository;

    @Autowired
    public SupervisorService(SupervisorRepository supervisorRepository, GrievanceRepository grievanceRepository, AssigneeRepository assigneeRepository){
        this.supervisorRepository = supervisorRepository;
        this.grievanceRepository = grievanceRepository;
        this.assigneeRepository = assigneeRepository;
    }

    public List<Supervisor> getAllSupervisors(){
        return supervisorRepository.findAll();
    }

    public List<Grievance> getAllGrievances(Long supervisorId) {

        Supervisor supervisor = supervisorRepository.findById(supervisorId)
                .orElseThrow(() -> new EntityNotFoundException("Supervisor not found with id: " + supervisorId));

        // Fetch and return the list of grievances associated with the Supervisor
        return supervisorRepository.findAllGrievancesBySupervisor(supervisor);
    }


    public Supervisor getSupervisorByAssigneeId(Long assigneeId) {
        return supervisorRepository.findAllSupervisorByAssigneeId(assigneeId);
                //.orElseThrow(() -> new RuntimeException("Supervisor not found for the given Assignee ID"));
    }

    public Supervisor updateSupervisor(Long supervisorId, Supervisor supervisorDetails) {
        Supervisor supervisor = supervisorRepository.findById(supervisorId)
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        supervisor.setSupervisorName(supervisorDetails.getSupervisorName());
        supervisor.setSupervisorEmail(supervisorDetails.getSupervisorEmail());
        supervisor.setSupervisorPassword(supervisorDetails.getSupervisorPassword());


        return supervisorRepository.save(supervisor);
    }

    public void assignToAssignee(Long grievanceId, Long assigneeId) {
        Grievance grievance = grievanceRepository.findById(grievanceId)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
        Assignee assignee = assigneeRepository.findById(assigneeId)
                .orElseThrow(() -> new RuntimeException("Assignee not found"));

        grievance.getAssignees().add(assignee);
        assignee.getAssignedGrievances().add(grievance);

        grievanceRepository.save(grievance);
        assigneeRepository.save(assignee);
    }


    public void removeAssignee(Long grievanceId, Long assigneeId){
        Grievance grievance = grievanceRepository.findById(grievanceId).orElseThrow(() -> new RuntimeException("Grievance not found"));
        Assignee assignee = assigneeRepository.findById(assigneeId).orElseThrow(()-> new RuntimeException("Assignee not found"));

        grievance.getAssignees().remove(assignee);
        assignee.getAssignedGrievances().remove(grievance);
        grievanceRepository.save(grievance);
        assigneeRepository.save(assignee);
    }

}
