package com.example.demo.entity.cloudTest;

import lombok.Data;

import javax.persistence.*;

@Table(name = "role")
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;
}
