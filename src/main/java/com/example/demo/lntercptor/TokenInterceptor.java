package com.example.demo.lntercptor;

import com.example.demo.entity.cloudTest.AppToken;
import com.example.demo.entity.cloudTest.User;
import com.example.demo.repository.cloudTest.AppTokenRepository;
import com.example.demo.repository.cloudTest.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utility.MD5Encryption;
import com.example.demo.validator.field.UserIdInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.SignatureException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TokenInterceptor implements HandlerInterceptor ,HandlerMethodArgumentResolver{
    private ConcurrentHashMap<String,User> concurrentHashMap = new ConcurrentHashMap();

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
        AppTokenRepository appTokenRepository = (AppTokenRepository) getDAO(AppTokenRepository.class,httpServletRequest);
        String signature = null;
        String timestamp = null;
        String userInfo = null;
        String noce = null;

        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("signature")){
                signature = cookie.getValue();
            }
            if (cookie.getName().equals("timestamp")){
                timestamp = cookie.getValue();
            }
            if (cookie.getName().equals("userInfo")){
                userInfo = cookie.getValue();
            }
            if (cookie.getName().equals("noce")){
                noce = cookie.getValue();
            }
        }

        AppToken appToken= null;
        if (userInfo!=null){
            appToken= appTokenRepository.findByAppId(userInfo);
        }
        try {
            if (appToken!=null){
                String verifySignature = MD5Encryption.tokenEncryption(timestamp,userInfo,noce,appToken.getToken());
                if (!verifySignature.equals(signature)){
                    throw new SecurityException("Token has an error");
                }else {
                    authHeader = appToken.getToken();
                    UserService userService = (UserService) getDAO(UserService.class,httpServletRequest);
                    User user = userService.findUser(Long.parseLong(userInfo));
                    concurrentHashMap.put("user",user);
                    httpServletRequest.setAttribute("user",user);
                }

            }
            if (authHeader ==null || authHeader.trim().equals("")){
                throw new SignatureException("not found Token");
            }

            Long nowTme = System.currentTimeMillis();

            if (appToken!=null){
                Long second = TimeUnit.MILLISECONDS.toSeconds(nowTme-Long.parseLong(appToken.getBuildTime()));
                if (second>0 && second<= 72000000){
                    Claims claims = Jwts.parser().setSigningKey("TokenTest"+userInfo).parseClaimsJws(authHeader).getBody();
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
            printWriter.write("Token 有误，重新登录！");
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

    /**
     * 下面2个方法用于自定义注解 获取当前用户token 属于哪个用户
     * @param methodParameter
     * @return
     */

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        System.out.println("supportsParameter");
        boolean info =  methodParameter.getParameterType().isAssignableFrom(User.class) && methodParameter.hasParameterAnnotation(UserIdInfo.class);
        return info;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest)  nativeWebRequest.getNativeRequest();
        User user =(User) request.getAttribute("user");
        return user;
    }
}
