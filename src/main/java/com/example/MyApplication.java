package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.CatalogConfig;
import com.example.model.CatalogAPI;
import com.example.model.Order;



@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
    AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(CatalogConfig.class);
        SpringApplication.run(MyApplication.class, args);
        CatalogAPI catalog=context.getBean("CatalogBean",CatalogAPI.class);
        catalog.test();
   
    }

    
}


