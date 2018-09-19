//package com.example.spring.boot.nosql;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.ServerAddress;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//
///**
// * Author: 王俊超
// * Date: 2017-08-27 13:42
// * All Rights Reserved !!!
// */
//public class MongoConfigSample {
//    @Bean
//    public MongoClient client () throws Exception {
//        return new MongoClient(new ServerAddress("127.0.0.1", 27017));
//    }
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception {
//        String database = new MongoClientURI("mongo://localhost/test").toString();
//        return new SimpleMongoDbFactory(client(), database);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongoDbFactory());
//    }
//}
