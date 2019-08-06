package com.example.demo.repository.test;

import com.example.demo.entity.test.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
