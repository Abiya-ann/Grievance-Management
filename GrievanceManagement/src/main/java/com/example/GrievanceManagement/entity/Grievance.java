package com.example.GrievanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceId;
    private String description;

    private String status;

    @CreatedDate
    @Column(name = "submission_date")
    private LocalDateTime submissionDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User  submittedBy;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category has;

    @ManyToMany(mappedBy = "assignedGrievances")
    private Set<Assignee> assignees;


}
