package com.example.demo;

import com.example.demo.config.PersonConfig;
import com.example.demo.entity.cloudTest.Person;
import com.example.demo.entity.test.Article;
import com.example.demo.entity.test.Book;
import com.example.demo.entity.test.Library;
import com.example.demo.entity.test.Student;
import com.example.demo.kafka.service.Consumer;
import com.example.demo.kafka.service.Producer;
import com.example.demo.service.StudentService;
import com.example.demo.testYpf.search.qichacha.QichachaUnit;
import com.example.demo.testYpf.search.tianyancha.TianyanchaUnit;
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
    @Autowired
    private QichachaUnit qichachaUnit;
    @Autowired
    private TianyanchaUnit tianyanchaUnit;

//    @Autowired
//    RedisService redisService;
//
//    @Test
//    public void testRedisSave(){
//        redisService.RedisSave();
//    }
//
//    @Test
//    public void testRedisGet(){
//        System.out.println("结果：：：");
//        redisService.RedisGet();
//    }

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


    @Test
    public void qichachaTest(){
        qichachaUnit.getInfoByInfo();
    }

    @Test
    public void tianyanchaTest(){
        String url = "https://open.api.tianyancha.com/services/v4/open/changeinfoV2?name=平安银行股份有限公司";
        tianyanchaUnit.getMessageByUrl(url);
    }
    @Autowired
    Producer producer;
    @Test
    public void testKafkaProducer() throws Exception{
       for (int i=0;i<5;i++){
           producer.senderMessage("这个是第"+i+"个测试消息");
       }
    }

}
