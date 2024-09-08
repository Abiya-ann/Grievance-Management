package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.Grievance;
import com.example.GrievanceManagement.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    @Query("SELECT g FROM Grievance g JOIN g.assignees a WHERE a.managedBy = :supervisor")
    List<Grievance> findAllGrievancesBySupervisor(@Param("supervisor") Supervisor supervisor);


    @Query("SELECT s FROM Supervisor s JOIN s.assignees a WHERE a.assigneeId = :assigneeId")
    Supervisor findAllSupervisorByAssigneeId(@Param("assigneeId") Long assigneeId);

    @Query("SELECT s FROM Supervisor s JOIN s.department d WHERE d.id = :departmentId")
    List<Supervisor> findByDepartmentId(@Param("departmentId") Long departmentId);


}
