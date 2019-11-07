package com.example.demo.kafka.topicProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka.topic")
@PropertySource(value = "classpath:kafka.properties")
public class KafkaTopicProperties implements Serializable {
    private String groupId;
    private String topicName;
}
