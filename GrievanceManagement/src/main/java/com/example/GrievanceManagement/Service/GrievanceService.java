package com.example.GrievanceManagement.Service;

import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.User;
import com.example.GrievanceManagement.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrievanceService {
    private final GrievanceRepository grievanceRepository;
    @Autowired
    public GrievanceService(GrievanceRepository grievanceRepository){
        this.grievanceRepository = grievanceRepository;
    }
    public Grievance submitGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    public List<Grievance> getAllGrievances(){
        return grievanceRepository.findAll();
    }
    public Optional<Grievance>getGrievanceById(Long grievanceId){
        return grievanceRepository.findById(grievanceId);
    }
    public void deleteGrievance(Long grievanceId){
        grievanceRepository.deleteById(grievanceId);
    }

    public Grievance updateGrievance(Long grievanceId, Grievance grievanceDetails) {
        Grievance grievance = grievanceRepository.findById(grievanceId).orElseThrow(() -> new RuntimeException("Grievance not found"));
        grievance.setStatus(grievanceDetails.getStatus());
        return grievanceRepository.save(grievance);
    }
    public List<Grievance> getGrievancesByUserId(Long userId) {
        return grievanceRepository.findBySubmittedByUserId(userId);
    }

    public String getStatusByGrievanceIdAndUserId(Long grievanceId, Long userId){
        return grievanceRepository.findStatusByGrievanceIdAndUserId(grievanceId, userId);
    }



}
