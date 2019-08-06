package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.RoleAndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleAndUserRepository extends JpaRepository<RoleAndUser,Long>, JpaSpecificationExecutor<RoleAndUser> {

     List<RoleAndUser> findByUserId(Long userId);
}
