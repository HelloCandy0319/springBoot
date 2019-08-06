package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(Principal principal){
//        UserDetails userDetails =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getName()+"Hello,Index";
    }
}
