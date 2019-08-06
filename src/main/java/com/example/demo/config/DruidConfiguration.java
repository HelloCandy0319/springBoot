package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.sql.DataSource;

@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean statViewBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //配置白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //黑名单
        servletRegistrationBean.addInitParameter("deny","123.0.0.6");
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","admin");
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statWebFilterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            druidDataSource.setFilters("stat");
        }catch (Exception e){
            e.printStackTrace();
        }
        return druidDataSource;
    }

//    @Bean
//    public JdkRegexpMethodPointcut jdkRegexpMethodPointcut(){
//        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
//        jdkRegexpMethodPointcut.setPatterns("com.example.demo.service.*");
//        return jdkRegexpMethodPointcut;
//    }



}
