package com.example.GrievanceManagement.repository;

import com.example.GrievanceManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
