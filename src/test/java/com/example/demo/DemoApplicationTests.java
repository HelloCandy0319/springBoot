package com.example.demo;

import com.example.demo.config.PersonConfig;
import com.example.demo.entity.cloudTest.Person;
import com.example.demo.entity.test.Article;
import com.example.demo.entity.test.Book;
import com.example.demo.entity.test.Library;
import com.example.demo.entity.test.Student;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource(name = "person")
    private Person person2;

    @Qualifier(value = "person")
    @Autowired
    private Person person1;
    @Autowired
    private StudentService studentService;
    @Test
    public void contextLoads() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person =(Person) applicationContext.getBean("person");
        System.out.println(person.toString());
//        String[] beanName = applicationContext.getBeanDefinitionNames();
//        for (String name:beanName){
//            System.out.println(name);
//        }
        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }

    @Test
    public void saveStudentLibrary(){
        Student student = new Student();
        Book book = new Book();
        List<Book> books = new ArrayList<>();
        book.setName("Cindy");
        books.add(book);
        Book book1 = new Book();
        book1.setName("Candy");
        books.add(book1);
        student.setName("张三");
        student.setBooks(books);
        Library library = new Library();
        library.setName("数学");
        library.setStudent(student);
        studentService.saveStudentLibraryInfo(library);
    }

    @Test
    public void saveArticlePerson(){
        Article article = new Article();
        article.setContent("哈哈哈哈哈哈哈");
        com.example.demo.entity.test.Person person = new com.example.demo.entity.test.Person();
        person.setArticle(article);
        person.setUsername("Candy");
        com.example.demo.entity.test.Person person3 = new com.example.demo.entity.test.Person();
        person3.setUsername("Cindy");
        person3.setArticle(article);
        List<com.example.demo.entity.test.Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person3);
        studentService.saveArticlePerson(personList);
    }

    @Test
    public void savePhoneUser(){
        studentService.savePhoneUser();
    }

    @Test
    public void deletePhone(){
        studentService.deletePhone();
    }
}
