//package com.example.demo.sercurity;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        logger.info("401错误");
//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access Denied");
//    }
//}
