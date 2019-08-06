package com.example.demo.entity.test;

import javax.persistence.Entity;

@Entity
public class ActiveEmployee extends Employee{
    private boolean active;
}
