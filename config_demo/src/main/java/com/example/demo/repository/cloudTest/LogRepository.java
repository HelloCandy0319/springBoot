package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
