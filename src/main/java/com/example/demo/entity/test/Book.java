package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_name")
    private String name;
}
