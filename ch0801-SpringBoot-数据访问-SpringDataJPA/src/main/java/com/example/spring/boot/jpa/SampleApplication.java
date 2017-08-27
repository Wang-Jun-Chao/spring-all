package com.example.spring.boot.jpa;

        import com.example.spring.boot.jpa.dao.PersonRepository;
        import com.example.spring.boot.jpa.support.CustomRepositoryFactoryBean;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Author: 王俊超
 * Date: 2017-07-17 21:19
 * All Rights Reserved !!!
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class SampleApplication {
    @Autowired
    PersonRepository personRepository;


    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);

    }
}
