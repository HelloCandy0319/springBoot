package com.example.demo.controller;

import com.example.demo.entity.test.Book;
import com.example.demo.repository.test.BookRepository;
import com.example.demo.validator.method.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Operation(value = "查询书籍信息")
    @GetMapping("/")
    public List<Book> bookList(){
        int re = 1/0;
        return bookRepository.findAll();
    }
}
