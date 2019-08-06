package com.example.demo.controller;

import com.example.demo.entity.mybaites.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @Transactional
    public void save(Employee employee){
        employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.employees();
    }

}
