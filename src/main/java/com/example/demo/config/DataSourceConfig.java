package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Bean(name = "cloudDateSource")
    @Qualifier("cloudDateSource")
    @ConfigurationProperties(prefix = "spring.datasource.jpa.cloudtest")
    public DataSource cloudTestDateSource(){
        DruidDataSource dataSource = new DruidDataSource();
       try {
           dataSource.setFilters("stat,wall,slf4j");
       }catch (Exception e){
           e.printStackTrace();
       }
       return dataSource;
    }

    @Bean(name = "testDateSource")
    @Qualifier("testDateSource")
    @ConfigurationProperties(prefix = "spring.datasource.jpa.test")
    @Primary
    public DataSource testDateSource(){
        DruidDataSource dataSource = new DruidDataSource();
        try {
           dataSource.setFilters("stat,wall,slf4j");
       }catch (SQLException e){
           e.printStackTrace();
       }
        return dataSource;
    }

    @Bean(name = "mybatisDataSource")
    @Qualifier("mybatisDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis")
    public DataSource mybatisDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setFilters("stat,wall,slf4j");
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return dataSource;
    }
}
