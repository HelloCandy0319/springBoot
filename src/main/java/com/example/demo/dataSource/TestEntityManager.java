package com.example.demo.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "testEntityManagerFactory",
        transactionManagerRef = "testTransactionManager",
        basePackages = {"com.example.demo.repository.test"}
)
public class TestEntityManager {

    @Autowired
    @Qualifier("testDateSource")
    private DataSource testDateSource;

    @Autowired
    private JpaProperties jpaProperties;


    @Bean(name = "testEntityManagers")
    public EntityManager entityManagers(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
            return testEntityManagerFactory(entityManagerFactoryBuilder).getObject().createEntityManager();
    }

    @Bean(name = "testEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean testEntityManagerFactory(EntityManagerFactoryBuilder builder){

        return builder.dataSource(testDateSource)
                .properties(getVendorProperties(testDateSource))
                .packages("com.example.demo.entity.test")       // 配置实体类位置
                .persistenceUnit("testPersistence")
                .build();
    }

    // 配置jpa 中的属性
    public Map<String,String> getVendorProperties(DataSource dataSource){
        return jpaProperties.getHibernateProperties(dataSource);
    }

    /**
     * 创建事务
     * @param entityManagerFactoryBuilder
     * @return
     */
    @Bean(name = "testTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        return new JpaTransactionManager(testEntityManagerFactory(entityManagerFactoryBuilder).getObject());
    }

}
