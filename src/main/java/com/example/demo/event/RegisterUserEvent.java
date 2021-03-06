package com.example.demo.event;

import com.example.demo.entity.cloudTest.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 注册用户事件
 */
@Getter
public class RegisterUserEvent extends ApplicationEvent {

    private User user;

    public RegisterUserEvent(Object source,User user) {
        super(source);
        this.user = user;
    }
}
