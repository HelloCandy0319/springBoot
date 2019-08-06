package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Book.class,cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book> books;
}
