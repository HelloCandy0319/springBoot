package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "library ")
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH})
    private Student student;
}
