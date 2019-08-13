package com.example.demo.sercurity;

import com.example.demo.controller.TokenController;
import com.example.demo.dto.TokenResult;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * 登录成功后的操作
 * 获取token
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        TokenController tokenController = (TokenController) getDAO(TokenController.class,httpServletRequest);
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        TokenResult tokenResult =  tokenController.token(principal.getUsername());
        // 此处需要对用户信息进行加密  原因是判断此Token是否属于当前用户操作的。
        String userInfo = principal.getUsername();
        if (tokenResult!=null){
            Cookie cookie = new Cookie("token",tokenResult.getToken());
            httpServletResponse.addCookie(cookie);
            httpServletResponse.setHeader("token",tokenResult.getToken());
            Cookie cookieUserInfo = new Cookie("userInfo",userInfo);
            httpServletResponse.addCookie(cookieUserInfo);
        }
        httpServletResponse.sendRedirect("/");
    }

    private Object getDAO(Class c,HttpServletRequest request){
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(c);
    }
}
