package com.example.demo;

import com.example.demo.config.PersonConfig;
import com.example.demo.entity.cloudTest.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonConfigTest {
    @Test
    public void testPerson(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person =(Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
