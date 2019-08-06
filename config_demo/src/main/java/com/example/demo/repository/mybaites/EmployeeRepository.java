package com.example.demo.repository.mybaites;

import com.example.demo.entity.mybaites.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmployeeRepository {

    @Select("select * from employee")
    @Results({
            @Result(column = "employee_name",property = "employeeName")
    })
    List<Employee> findAll();

    @Insert("INSERT INTO employee(employee_name,age) VALUES (#{employeeName},#{age})")
    @Results({
            @Result(column = "employee_name",property = "employeeName")
    })
    void save(Employee employee);
}
