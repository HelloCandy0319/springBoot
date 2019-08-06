package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Article article;
}
