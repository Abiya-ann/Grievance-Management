package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

        List<Grievance> findBySubmittedByUserId(Long userId);


        @Query("SELECT g FROM Grievance g JOIN g.assignees a WHERE a.assigneeId = :assigneeId")
        List<Grievance> findByAssigneesId(@Param("assigneeId") Long assigneeId);

        @Query("SELECT g.status FROM Grievance g WHERE g.grievanceId = :grievanceId AND g.submittedBy.id = :userId")
        String findStatusByGrievanceIdAndUserId(@Param("grievanceId") Long grievanceId, @Param("userId") Long userId);
}






