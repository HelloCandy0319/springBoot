package com.example.demo.service;

import com.example.demo.dto.DeptDto;
import com.example.demo.dto.EmpDeptDto;
import com.example.demo.dto.ParentDeptDto;
import com.example.demo.entity.mybaites.Department;
import com.example.demo.repository.mybaites.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> departmentList(){
        return departmentRepository.departmentList();
    }

    public void saveDept(Department department){

        departmentRepository.saveDept(department);
    }

    public Department getDept(Long id){
        return departmentRepository.getDept(id);
    }

    public List<ParentDeptDto> deptDtoList(){
        List<DeptDto> deptDtoList =  departmentRepository.deptToEmp();
        List<Department> departments = departmentRepository.departmentList();
        List<EmpDeptDto> res = new ArrayList<>();
        for (Department department:departments){
            List<DeptDto> deptDtos = new ArrayList<>();
            EmpDeptDto empDeptDto = new EmpDeptDto();
            for (DeptDto deptDto:deptDtoList){
                if (department.getId() == (deptDto.getDeptId())){
                       empDeptDto.setDeptId(deptDto.getDeptId());
                       empDeptDto.setParentDept(deptDto.getParentDept());
                       deptDtos.add(deptDto);
                       empDeptDto.setDeptDtos(deptDtos);
                       empDeptDto.setDeptName(deptDto.getDeptName());
                }
            }
            res.add(empDeptDto);
        }
        List<ParentDeptDto> parentDeptDtoList = parentDeptDtoList(res);
        List<EmpDeptDto> deleteParent = new ArrayList<>();
        for (EmpDeptDto empDeptDto:res){
            if (empDeptDto.getParentDept()==null){
                deleteParent.add(empDeptDto);
            }
        }
        res.removeAll(deleteParent);
        List<ParentDeptDto> treeEmpDept = treeEmpDept(res,parentDeptDtoList);
        return treeEmpDept;
    }

    private List<ParentDeptDto> parentDeptDtoList(List<EmpDeptDto> deptDtoList){
        List<ParentDeptDto> parentDeptDtoList = new ArrayList<>();
        for (EmpDeptDto empDeptDto:deptDtoList){
            if (empDeptDto.getParentDept()==null){
                ParentDeptDto parentDeptDto = new ParentDeptDto();
                parentDeptDto.setDeptId(empDeptDto.getDeptId());
                parentDeptDto.setDeptName(empDeptDto.getDeptName());
                parentDeptDtoList.add(parentDeptDto);
            }
        }
        return parentDeptDtoList;
    }
    private List<ParentDeptDto> treeEmpDept(List<EmpDeptDto> deptDtoList,List<ParentDeptDto> parentDeptDtoList){
                for (ParentDeptDto parentDeptDto:parentDeptDtoList){
                    for (EmpDeptDto empDeptDto:deptDtoList){
                    if (empDeptDto.getParentDept() == parentDeptDto.getDeptId()){
                       List<EmpDeptDto> childEmp = parentDeptDto.getChildDept();
                       if (childEmp==null){
                           childEmp = new ArrayList<>();
                       }
                       if (empDeptDto.getDeptId()==3){
                           System.out.println(3333333);
                       }
                        if (empDeptDto.getDeptId()==5){
                            System.out.println(empDeptDto.getDeptName());
                        }
                       childEmp.add(empDeptDto);
                       parentDeptDto.setChildDept(childEmp);
                        System.out.println("sssss");
                    }else {
                        List<EmpDeptDto> childEmp = parentDeptDto.getChildDept();
                        if (childEmp!=null){
                            for (EmpDeptDto deptDto:childEmp){
                                if (deptDto.getDeptId()==3){
                                    System.out.println(deptDto.getDeptName());
                                }
                                List<ParentDeptDto> parentDeptDtos = new ArrayList<>();
                                ParentDeptDto parentDeptDto1 = new ParentDeptDto();
                                parentDeptDto1.setDeptId(deptDto.getDeptId());
                                parentDeptDto1.setDeptName(deptDto.getDeptName());
                                parentDeptDtos.add(parentDeptDto1);
                                treeEmpDept(deptDtoList,parentDeptDtos);
                            }
                        }
                    }
                }
            }
            return parentDeptDtoList;
    }
}
