package com.example.demo.repository.mybaites;

import com.example.demo.dto.EmployeeToDept;
import com.example.demo.entity.mybaites.Employee;
import com.example.demo.repository.mybaites.provider.EmployeeSqlProvider;
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

    @Insert({"INSERT INTO employee(employee_name,age,dept_id) VALUES (#{employeeName},#{age},#{deptId})"})
    @Results({
            @Result(column = "employee_name",property = "employeeName"),
            @Result(column = "dept_id",property = "deptId")
    })
    void save(Employee employee);

    @SelectProvider(type = EmployeeSqlProvider.class,method = "selectEmployee")
    public Employee getEmployee(Long empId);


    @Select("SELECT e.`employee_name` AS employeeName, e.`id` AS employeeId,d.`dept_name` AS deptName,d.`id` AS deptId " +
            "FROM employee e INNER JOIN department d ON e.`dept_id` = d.`id` WHERE e.`id`= #{id}")
     EmployeeToDept findEmployeeToDept(Long id);
}
