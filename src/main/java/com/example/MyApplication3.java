package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.EnterpriseAPIConfig;
import com.example.model.EnterpriseCustomer;


@SpringBootApplication
//@ComponentScan(basePackages = "com.example.service")
public class MyApplication3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context3= new AnnotationConfigApplicationContext(EnterpriseAPIConfig.class);
        SpringApplication.run(MyApplication3.class, args);
        EnterpriseCustomer enterprise=context3.getBean("enterpriseBean",EnterpriseCustomer.class);
        enterprise.test();
    }
}