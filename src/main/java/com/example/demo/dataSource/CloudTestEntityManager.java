package com.example.demo.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "cloudTestEntityManagerFactory",
        transactionManagerRef = "cloudTestPlatformTransactionManager",
        basePackages = {"com.example.demo.repository.cloudTest"}
)
public class CloudTestEntityManager {
    @Autowired
    @Qualifier("cloudDateSource")
    private DataSource cloudDateSource;


    @Bean("cloudEntityManager")
    @Primary
    public EntityManager cloudEntityManager(EntityManagerFactoryBuilder builder){
        return cloudTestEntityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean("cloudTestEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean cloudTestEntityManagerFactoryBean(EntityManagerFactoryBuilder builder){
        HashMap<String,String> map = new HashMap();
        return builder.dataSource(cloudDateSource)
                .properties(getVendorProperties(cloudDateSource))
                .packages("com.example.demo.entity.cloudTest")
                .persistenceUnit("cloudTestPersistence")
                .build();
    }
    @Autowired
    private JpaProperties  jpaProperties;

    public Map<String,String> getVendorProperties(DataSource dataSource){
        Map<String,String> map= jpaProperties.getHibernateProperties(dataSource);
        map.put("determineDatabase","org.hibernate.dialect.MySQL5InnoDBDialect");
        return map;
    }

    @Bean("cloudTestPlatformTransactionManager")
    @Primary
    public PlatformTransactionManager cloudTestPlatformTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(cloudTestEntityManagerFactoryBean(builder).getObject());
    }
}
