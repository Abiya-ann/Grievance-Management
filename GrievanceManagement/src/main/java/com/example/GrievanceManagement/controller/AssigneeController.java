package com.example.GrievanceManagement.controller;

import com.example.GrievanceManagement.Service.AssigneeService;
import com.example.GrievanceManagement.entity.Assignee;
import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignees")

public class AssigneeController {
    private final AssigneeService assigneeService;
    @Autowired
    public AssigneeController(AssigneeService assigneeService){
        this.assigneeService = assigneeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Assignee> createAssignee(@RequestBody Assignee assignee){
        Assignee savedassignee = assigneeService.saveAssignee(assignee);
        return ResponseEntity.ok(savedassignee);
    }

    @GetMapping("/all")
    public ResponseEntity<List <Assignee>>getAllAssignee(){
        List<Assignee> assignee= assigneeService.getAllAssignee();
        return ResponseEntity.ok(assignee);

    }

    @GetMapping("/{assigneeId}")
    public ResponseEntity<Assignee> getAssigneeById(@PathVariable Long id) {
        Optional<Assignee> assignee= assigneeService.getAssigneeById(id);
        return assignee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{assigneeId}")
    public ResponseEntity<Void> deleteAssignee(@PathVariable Long id) {

            assigneeService.deleteAssignee(id);
            return ResponseEntity.noContent().build();

    }
    @PutMapping("/{assigneeId}")
    public ResponseEntity<Assignee> updateAssignee(@PathVariable Long assigneeId, @RequestBody Assignee assigneeDetails) {
        Assignee updatedAssignee = assigneeService.updateAssignee(assigneeId, assigneeDetails);
        return ResponseEntity.ok(updatedAssignee);
    }

    @GetMapping("/{assigneeId}/grievances")
    public ResponseEntity<List<Grievance>> getAllGrievancesOfAnAssignee(@PathVariable Long assigneeId) {

            List<Grievance> grievances = assigneeService.getAllGrievancesOfAnAssignee(assigneeId);
            return ResponseEntity.ok(grievances);

    }
    @GetMapping("/grievances/{grievanceId}/assignees")
    public ResponseEntity<List<Assignee>> getAssigneesByGrievanceId(@PathVariable Long grievanceId) {

            List<Assignee> assignees = assigneeService.getAssigneesByGrievanceId(grievanceId);
            return ResponseEntity.ok(assignees);


    }

}




