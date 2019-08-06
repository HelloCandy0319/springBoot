package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    @Query(value = "select * from user where age >?1",nativeQuery=true)
    public List<User> findUsersGrants(int age);

    public User findByUsername(String username);
}
