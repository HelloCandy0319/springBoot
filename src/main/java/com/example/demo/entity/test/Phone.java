package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(targetEntity = User.class,cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<User> users;
}
