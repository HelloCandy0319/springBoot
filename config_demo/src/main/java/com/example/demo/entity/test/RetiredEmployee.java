package com.example.demo.entity.test;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class RetiredEmployee extends Employee {
    private boolean retired;
}
