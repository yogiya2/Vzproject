package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.example.config.SercviceAPIConfig;

import com.example.model.ServiceService;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.service")
public class MyApplication2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context2= new AnnotationConfigApplicationContext(SercviceAPIConfig.class);
        SpringApplication.run(MyApplication2.class, args);
        ServiceService service=context2.getBean("serviceBean",ServiceService.class);
        service.test();
    }
}



