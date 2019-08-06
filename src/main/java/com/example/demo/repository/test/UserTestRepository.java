package com.example.demo.repository.test;

import com.example.demo.entity.test.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTestRepository extends JpaRepository<User,Long> {
}
