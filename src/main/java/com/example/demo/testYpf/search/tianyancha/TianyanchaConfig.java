package com.example.demo.testYpf.search.tianyancha;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource(value = "classpath:TianyanchaConfig.properties")
@ConfigurationProperties(prefix = "com.tianyancha")
public class TianyanchaConfig {
        private String token;
}
