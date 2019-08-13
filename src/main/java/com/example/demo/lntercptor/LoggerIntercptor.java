package com.example.demo.lntercptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.cloudTest.Log;
import com.example.demo.repository.cloudTest.LogRepository;
import com.example.demo.validator.field.UserIdInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Date;

public class LoggerIntercptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Log log  = new Log();
        String url = request.getRequestURI();
        String param = JSON.toJSONString(request.getParameterMap());
        log.setMethod(request.getMethod());
        log.setParamData(param);
        log.setClientUrl(url);
        log.setBeginTime(new Date());
        request.setAttribute("log",log);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Transactional
    @Override
    @UserIdInfo(userId = )
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Log log = (Log) request.getAttribute("log");
        log.setReturnTime(new Date());
        LogRepository logRepository = (LogRepository) getDAO(LogRepository.class,request);
        logRepository.save(log);
    }

    public Object getDAO(Class c,HttpServletRequest request){
        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return beanFactory.getBean(c);
    }
}
