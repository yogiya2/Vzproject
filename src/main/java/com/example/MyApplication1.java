package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.example.config.OrderingAPIConfig;

import com.example.model.Order;



@SpringBootApplication
public class MyApplication1 {

    public static void main(String[] args) {
    AnnotationConfigApplicationContext context1= new AnnotationConfigApplicationContext(OrderingAPIConfig.class);
        SpringApplication.run(MyApplication1.class, args);
        Order order=context1.getBean("OrderBean",Order.class);
        order.test();
   
    }

    
}
