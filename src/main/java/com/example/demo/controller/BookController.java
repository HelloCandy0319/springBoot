package com.example.demo.controller;

import com.example.demo.entity.cloudTest.User;
import com.example.demo.entity.test.Book;
import com.example.demo.kafka.service.Producer;
import com.example.demo.repository.test.BookRepository;
import com.example.demo.validator.field.UserIdInfo;
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
    @GetMapping("/books")
    public List<Book> bookList(@UserIdInfo User userId){
        System.out.println("Books"+userId);
//        int re = 1/0;
        return bookRepository.findAll();
    }
    @Autowired
    Producer producer;
    @GetMapping("/")
    public void testKafka(){
        producer.senderMessage("这个是个测试信息");
    }
}
