package com.example.demo.config;

import com.example.demo.entity.cloudTest.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Hashtable;

@Configuration
@Import({HashMap.class, Hashtable.class})
public class PersonConfig {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("Cindy");
        person.setAge(10);
        return person;
    }

    public void init(){
        System.out.println("初始化");
    }

    public void destroy(){
        System.out.println("销毁");
    }
}
