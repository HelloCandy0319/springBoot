package com.example.demo.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = "com.example.demo.repository.mybaites",
        sqlSessionFactoryRef = "mybatisSqlSessionFactory"
)
public class mybatisEntityManager {
    @Autowired
    @Qualifier("mybatisDataSource")
    private DataSource mybatisDataSource;

    @Bean(name = "mybatisSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory(@Qualifier("mybatisDataSource") DataSource mybatisDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mybatisDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.example.demo.entity.mybaites");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatisSqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean(name = "mybatisDatasourceTransactionManager")
    public DataSourceTransactionManager mybatisDatasourceTransactionManager(@Qualifier("mybatisDataSource") DataSource mybatisDataSource){
        return new DataSourceTransactionManager(mybatisDataSource);
    }
}
