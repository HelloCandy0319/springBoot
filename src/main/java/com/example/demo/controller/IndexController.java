package com.example.demo.controller;

import com.example.demo.dto.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class IndexController {
//    @Autowired
//    TokenController tokenController;
    @GetMapping("/")
    public String index(Principal principal, HttpServletResponse response){
//        UserDetails userDetails =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       TokenResult tokenResult =  tokenController.token(principal.getName());
//        if (tokenResult!=null){
//            Cookie cookie = new Cookie("token",tokenResult.getToken());
//            response.addCookie(cookie);
//        }
        return principal.getName()+"Hello,Index";
    }
}
