package com.example.demo.kafka.service;

import com.example.demo.kafka.topicProperties.KafkaTopicProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    KafkaTopicProperties kafkaTopicProperties;
    @Bean
    public String topicName(){
        logger.info("------------"+kafkaTopicProperties.getTopicName());
        return kafkaTopicProperties.getTopicName();
    }

    @Bean
    public String groupId(){
        return kafkaTopicProperties.getGroupId();
    }

    private final static Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "#{topicName}",groupId = "#{groupId}")
    public Object receiverMessage(ConsumerRecord<String,Object> record){
        logger.info("receiver Message");
        logger.info("接收到信息啦");
        logger.info("Message is "+ record.topic()+"--------"+record.value());
        return record.value();
    }
}
