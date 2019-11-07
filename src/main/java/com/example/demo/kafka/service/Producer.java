package com.example.demo.kafka.service;

import com.example.demo.kafka.topicProperties.KafkaTopicProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Producer {
    @Autowired
    private KafkaTopicProperties kafkaTopicProperties;

    private final static Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired
    KafkaTemplate kafkaTemplate;


    public void senderMessage(Object message){
        logger.info("kafka send messages");
        String topic = kafkaTopicProperties.getTopicName();
        ListenableFuture<SendResult<String,Object>> future = kafkaTemplate.send(topic,message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info(topic+"-----消息发送失败------"+throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                logger.info(topic+"-----消息发送成功------"+stringObjectSendResult);
            }
        });
    }
}
