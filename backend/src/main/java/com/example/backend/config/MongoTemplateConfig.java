package com.example.backend.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoTemplateConfig{

    @Value("${spring.data.mongodb.database}")
    private String db;

    @Bean
    public MongoClient mongo(){
        return new MongoClient("localhost",27017);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(),"COLFAX");
    }
}
