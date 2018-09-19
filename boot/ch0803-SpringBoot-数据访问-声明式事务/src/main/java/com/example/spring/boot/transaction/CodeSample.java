//package com.example.spring.boot.transaction;
//
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * Author: 王俊超
// * Date: 2017-09-04 06:55
// * All Rights Reserved !!!
// */
//public class CodeSample {
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setDataSource(dataSource());
//
//        return transactionManager;
//    }
//}
