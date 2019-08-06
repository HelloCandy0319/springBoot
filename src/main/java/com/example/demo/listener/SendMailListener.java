package com.example.demo.listener;

import com.example.demo.event.RegisterUserEvent;
import com.example.demo.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendMailListener implements SmartApplicationListener {
    /**
     * 只有UserRegisterEvent监听类型才会执行下面逻辑
     * 返回值为true
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == RegisterUserEvent.class;
    }

    /**
     *  只有在UserService内发布的UserRegisterEvent事件时才会执行下面逻辑
     *  返回值为true
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == UserService.class;
    }

    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        RegisterUserEvent registerUserEvent = (RegisterUserEvent) applicationEvent;
        System.out.println("发送邮件"+registerUserEvent.getUser().toString());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
