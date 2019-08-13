package com.example.demo.lntercptor;

import com.example.demo.entity.cloudTest.AppToken;
import com.example.demo.entity.cloudTest.User;
import com.example.demo.repository.cloudTest.AppTokenRepository;
import com.example.demo.repository.cloudTest.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.SignatureException;
import java.util.concurrent.TimeUnit;

public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if (httpServletRequest.getRequestURI().equals("/token")
                || httpServletRequest.getRequestURI().equals("/login")
                || httpServletRequest.getRequestURI().equals("/error")
                || RequestMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
            return true;
        }
         String authHeader = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                authHeader = cookie.getValue();
            }
        }
        try {
            if (authHeader ==null || authHeader.trim().equals("")){
                throw new SignatureException("not found Token");
            }
            AppTokenRepository appTokenRepository = (AppTokenRepository) getDAO(AppTokenRepository.class,httpServletRequest);
            AppToken appToken = null;
            Long nowTme = System.currentTimeMillis();
            appToken = appTokenRepository.findFirstByToken(authHeader);
            if (appToken!=null){
                Long second = TimeUnit.MILLISECONDS.toSeconds(nowTme-Long.parseLong(appToken.getBuildTime()));
                if (second>0 && second<= 72000000){
                    Claims claims = Jwts.parser().setSigningKey("Cindy V1.0").parseClaimsJws(authHeader).getBody();
                    appToken = appTokenRepository.findByAppId(claims.getSubject());
                    String token = null;
                    if (appToken!=null){
                        token = appToken.getToken();
                    }
                    if (token == null || token.trim().equals("")){
                        throw new SignatureException("token not found ,please get token again");
                    }
                    if (!token.equals(authHeader)){
                        throw new SignatureException("token is Invalid");
                    }
                }else {
                    throw new SignatureException("token 过期");
                }
            }
        }catch (SignatureException s){
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.write("need Token");
            printWriter.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private Object getDAO(Class c,HttpServletRequest request){
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(c);
    }
}
