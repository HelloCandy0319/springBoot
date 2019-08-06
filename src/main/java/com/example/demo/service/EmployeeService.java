package com.example.demo.service;

import com.example.demo.entity.mybaites.Employee;
import com.example.demo.repository.mybaites.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> employees(){
        return employeeRepository.findAll();
    }
}

