package com.example.demo.listener;

import com.example.demo.entity.cloudTest.User;
import com.example.demo.event.RegisterUserEvent;
import com.example.demo.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 注册用户 监听器
 */
@Component
public class AnnotationRegisterListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == RegisterUserEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == UserService.class;
    }

    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        RegisterUserEvent userEvent = (RegisterUserEvent) applicationEvent;
        User user = userEvent.getUser();
        System.out.println("注册中心监听器，注册用户是"+user.toString());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
