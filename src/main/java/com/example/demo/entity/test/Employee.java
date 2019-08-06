package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
