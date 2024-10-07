package com.example.GrievanceManagement.controller;

import com.example.GrievanceManagement.Service.GrievanceService;
import com.example.GrievanceManagement.Service.SupervisorService;


import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    private final SupervisorService supervisorService;
    private final GrievanceService grievanceService;
    @Autowired
    public SupervisorController(SupervisorService supervisorService, GrievanceService grievanceService){
        this.supervisorService = supervisorService;
        this. grievanceService = grievanceService;
    }
    @GetMapping("/all")
    public ResponseEntity <List<Supervisor>> getAllSupervisors(){
        List <Supervisor> supervisors = supervisorService.getAllSupervisors();
        return ResponseEntity.ok(supervisors);
    }

    @PutMapping("/{supervisorId}")
    public Supervisor updateSupervisor(@PathVariable Long supervisorId, @RequestBody Supervisor supervisor){
        return supervisorService.updateSupervisor(supervisorId, supervisor);
    }


    @GetMapping("/{supervisorId}/grievances")
    public ResponseEntity <List<Grievance>> getAllGrievances(@PathVariable Long supervisorId){
        List <Grievance> grievances = supervisorService.getAllGrievances(supervisorId);
        return ResponseEntity.ok(grievances);
    }
    @GetMapping("/assignee/{assigneeId}")
    public ResponseEntity <Supervisor> getSupervisorByAssigneeId(@PathVariable Long assigneeId){
        Supervisor supervisor = supervisorService.getSupervisorByAssigneeId(assigneeId);
        return ResponseEntity.ok(supervisor);
    }

    @PostMapping("/assign/{grievanceId}/to/{assigneeId}")
    public ResponseEntity<Void> assignToAssignee(@PathVariable Long grievanceId, @PathVariable Long assigneeId) {
        supervisorService.assignToAssignee(grievanceId, assigneeId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/remove/{grievanceId}/from/{assigneeId}")
            public ResponseEntity<Void> removeAssignee(@PathVariable Long grievanceId, @PathVariable Long assigneeId){
        supervisorService.removeAssignee(grievanceId, assigneeId);
        return ResponseEntity.noContent().build();
    }

}
