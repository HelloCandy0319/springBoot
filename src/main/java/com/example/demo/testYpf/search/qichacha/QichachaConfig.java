package com.example.demo.testYpf.search.qichacha;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource(value = "classpath:QichachaConfig.properties")
@Configuration
@ConfigurationProperties(prefix = "com.qichacha")
public class QichachaConfig {
    private String appkey;
    private String seckey;
}
