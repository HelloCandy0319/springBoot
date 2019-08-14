package com.example.demo.sercurity;

import com.example.demo.controller.TokenController;
import com.example.demo.dto.TokenResult;
import com.example.demo.entity.cloudTest.User;
import com.example.demo.repository.cloudTest.UserRepository;
import com.example.demo.utility.MD5Encryption;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
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
import java.util.Random;

/**
 * 登录成功后的操作
 * 获取token
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        TokenController tokenController = (TokenController) getDAO(TokenController.class,httpServletRequest);
        UserRepository userRepository = (UserRepository) getDAO(UserRepository.class,httpServletRequest);
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        TokenResult tokenResult =  tokenController.token(principal.getUsername());
        // 此处需要对用户信息进行加密  原因是判断此Token是否属于当前用户操作的。
        String userInfo = principal.getUsername();
        User user = userRepository.findByUsername(userInfo);
        String timestamp = System.currentTimeMillis()+"";
        Random r = new Random(1);
        String noce = r.nextInt(100)+"";
        if (tokenResult!=null){
            String signature = MD5Encryption.tokenEncryption(timestamp,user.getId()+"",noce,tokenResult.getToken());
            Cookie signatureCookie = new Cookie("signature",signature);
            httpServletResponse.addCookie(signatureCookie);
            Cookie userInfoCookie = null;
            if (user!=null){
                 userInfoCookie = new Cookie("userInfo",user.getId()+"");
            }
            Cookie noceCookie = new Cookie("noce",noce);
            Cookie timestampCookie = new Cookie("timestamp",timestamp);
            httpServletResponse.addCookie(userInfoCookie);
            httpServletResponse.addCookie(noceCookie);
            httpServletResponse.addCookie(timestampCookie);
        }
        httpServletResponse.sendRedirect("/");
    }

    private Object getDAO(Class c,HttpServletRequest request){
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(c);
    }

}
