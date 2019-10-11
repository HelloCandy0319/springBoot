package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog,Long> {
}
