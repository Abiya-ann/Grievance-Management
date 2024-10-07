package com.example.GrievanceManagement.controller;

import com.example.GrievanceManagement.Service.GrievanceService;
import com.example.GrievanceManagement.Service.UserService;
import com.example.GrievanceManagement.entity.Grievance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grievances")
public class GrievanceController {
    private final GrievanceService grievanceService;
   @Autowired
    public GrievanceController(GrievanceService grievanceService){
        this.grievanceService = grievanceService;
    }

    @GetMapping("/all")
    public ResponseEntity <List<Grievance>> getAllGrievances(){
        List <Grievance> grievances = grievanceService.getAllGrievances();
        return ResponseEntity.ok(grievances);
    }
    @GetMapping("/{grievanceId}")
    public ResponseEntity <Grievance> getGrievanceById(@PathVariable Long grievanceId){
        Optional<Grievance> grievance = grievanceService.getGrievanceById(grievanceId);
        return grievance.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{grievanceId}")
    public ResponseEntity<Void> deleteGrievanceById(@PathVariable Long grievanceId){
        grievanceService.deleteGrievance(grievanceId);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{grievanceId}")
    public Grievance updateGrievance(@PathVariable Long grievanceId, @RequestBody Grievance grievance){
        return grievanceService.updateGrievance(grievanceId, grievance);
    }
    @PostMapping
    public ResponseEntity<Grievance> submitGrievance(@RequestBody Grievance grievance) {
        Grievance savedGrievance = grievanceService.submitGrievance(grievance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGrievance);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity <List <Grievance>> getGrievancesByUserId(@PathVariable Long userId){
        List <Grievance> grievances = grievanceService.getGrievancesByUserId(userId);
        return ResponseEntity.ok(grievances);
    }
    @GetMapping("{grievanceId}/status")
    public ResponseEntity <String> getStatusByGrievanceIdAndUserId(@PathVariable Long grievanceId, @RequestParam Long userId){
     String status= grievanceService.getStatusByGrievanceIdAndUserId(grievanceId, userId);
     return ResponseEntity.ok(status);
    }
}
