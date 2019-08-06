package com.example.demo.repository.test;

import com.example.demo.entity.test.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
