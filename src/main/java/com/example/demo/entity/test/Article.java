package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;
}
