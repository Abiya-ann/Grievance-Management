package com.example.GrievanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "has", cascade = CascadeType.ALL)
    private Set<Grievance> grievances;
}
