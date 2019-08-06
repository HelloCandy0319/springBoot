package com.example.demo.repository.test;

import com.example.demo.entity.test.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
