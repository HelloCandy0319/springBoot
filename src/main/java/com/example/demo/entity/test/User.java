package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Phone.class,fetch = FetchType.EAGER ,cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Phone> phones;
}
