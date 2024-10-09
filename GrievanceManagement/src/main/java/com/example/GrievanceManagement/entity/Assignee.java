package com.example.GrievanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Assignee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long assigneeId;
    private String assigneeName;
    private String assigneeEmail;
    private String assigneePassword;
    private String role;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "supervisor_id")
    private Supervisor managedBy;

    @ManyToMany
     @JsonIgnore
    @JoinTable(
            name="assignee_grievance",
            joinColumns=@JoinColumn(name="assignee_id"),
            inverseJoinColumns = @JoinColumn(name="grievance_id")
    )

    private Set<Grievance> assignedGrievances;
    @ManyToOne
     @JsonIgnore
    @JoinColumn(name = "department_id")
    private Department department;


}
