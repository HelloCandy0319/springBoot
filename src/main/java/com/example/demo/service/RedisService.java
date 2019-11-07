//package com.example.demo.service;
//
//import com.example.demo.entity.cloudTest.User;
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    @Qualifier(value = "redissonClient")
//    RedissonClient redissonClient;
//
//    public void RedisSave(){
//        User user = new User("Cindy","12345678",18,"2");
//        RBucket<User> userRBucket =  redissonClient.getBucket(user.getUsername());
//        userRBucket.set(user);
//    }
//
//    public void RedisGet(){
//        RBucket<User> userRBucket =  redissonClient.getBucket("Cindy");
//        User user = userRBucket.get();
//        System.out.println("结果：：：");
//        System.out.println(user.toString());
//    }
//}
