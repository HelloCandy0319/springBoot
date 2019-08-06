package com.example.demo.entity.mybaites;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private Long id;
    private String employeeName;
    private int age;
}
