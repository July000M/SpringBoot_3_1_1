package com.example.springboot_3_1_1.repository;

import com.example.springboot_3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
