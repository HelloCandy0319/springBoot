package com.example.demo.controller;

import com.example.demo.entity.cloudTest.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public List<User> userList(){
        return userService.userList();
    }
    @GetMapping(value = "/grantsAge",params = "age")
    public List<User> findUsersGrants(int age){
        return userService.findUsersGrants(age);
    }

    @PostMapping("/")
    public String saveInfo(@Valid User user){
        userService.register(user);
        return user.toString();
    }

    @PostMapping("/find")
    public List<User> findUser(@Valid User user){
      return   userService.findUserInfo(user);
    }


}
