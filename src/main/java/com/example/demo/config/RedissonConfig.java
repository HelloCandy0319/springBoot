//package com.example.demo.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//

/**
 * 本机 未搭建 redis集群 所以先注释掉
 */
//@Configuration
//public class RedissonConfig {
//
//    @Value("${spring.redis.cluster.nodes}")
//    private String clusters;
//
//    @Bean
//    public RedissonClient redissonClient(){
//        String [] nodes = clusters.split(",");
//        for (int i=0;i<nodes.length;i++){
//            nodes[i] = "redis://"+nodes[i];
//        }
//        RedissonClient redissonClient = null;
//        Config config = new Config();
//        config.useClusterServers().addNodeAddress(nodes).setScanInterval(2000);
//        redissonClient = Redisson.create(config);
//        return redissonClient;
//    }
//
//}
//
