package com.example.demo.service;

import com.example.demo.entity.test.Library;
import com.example.demo.entity.test.Person;
import com.example.demo.entity.test.Phone;
import com.example.demo.entity.test.User;
import com.example.demo.repository.test.LibraryRepository;
import com.example.demo.repository.test.StudentRepository;
import com.example.demo.repository.test.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    @Qualifier("testEntityManagers")
    EntityManager testEntityManagers;
    @Value("${server.port}")
    private String port;

    public void saveStudentLibraryInfo(Library library){
        transaction(library);
    }

    public void saveArticlePerson(List<Person> personList){
        for (Person person: personList){
            testEntityManagers.getTransaction().begin();
            testEntityManagers.persist(person);
            testEntityManagers.getTransaction().commit();
        }
        testEntityManagers.close();
    }

    private void transaction(Object object){
        testEntityManagers.getTransaction().begin();
        testEntityManagers.persist(object);
        testEntityManagers.getTransaction().commit();
        testEntityManagers.close();
    }

    public void savePhoneUser(){
        testEntityManagers.getTransaction().begin();
        Phone phone = new Phone();
        phone.setName("小米8");
        Phone phone1 = new Phone();
        phone1.setName("小米9");
        User user = new User();
        user.setName("张三");
        User user1 = new User();
        user1.setName("李四");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        phones.add(phone1);
        List<Phone> phones1 = new ArrayList<>();
        phones1.add(phone);
        phones1.add(phone1);
        user.setPhones(phones);
        user1.setPhones(phones1);
        testEntityManagers.persist(user);
        testEntityManagers.persist(user1);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        List<User> userList = new ArrayList<>();
        userList.add(user) ;
        userList.add(user1);
//        phone.setUsers(users);
//        phone1.setUsers(userList);
        testEntityManagers.persist(phone);
        testEntityManagers.persist(phone1);
        testEntityManagers.getTransaction().commit();
        testEntityManagers.close();
    }

    @Autowired
    UserTestRepository userRepository;

    public List<User> findUser(){
        return userRepository.findAll();
    }

    public void deletePhone(){
        testEntityManagers.getTransaction().begin();
        Phone phone = testEntityManagers.find(Phone.class,5L);
        testEntityManagers.remove(phone);
        testEntityManagers.getTransaction().commit();
        testEntityManagers.close();
    }


}
