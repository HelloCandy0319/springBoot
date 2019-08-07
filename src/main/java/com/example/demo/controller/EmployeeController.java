package com.example.demo.controller;

import com.example.demo.dto.EmployeeToDept;
import com.example.demo.entity.mybaites.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @Transactional
    public void save(@Validated Employee employee){
        employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.employees();
    }

    @GetMapping("/empInfo")
    public EmployeeToDept employeeToDept(@RequestParam(name = "id") Long id){
        return employeeService.findEmployeeDept(id);
    }

}
