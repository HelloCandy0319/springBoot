package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@ServletComponentScan
@ImportResource(locations = {"classpath:druid-bean.xml"})
@SpringBootApplication
public class DemoApplication {
    private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        logger.info("开始启动.................");
        SpringApplication.run(DemoApplication.class, args);
    }

}
