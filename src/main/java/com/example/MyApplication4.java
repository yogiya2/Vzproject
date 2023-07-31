package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.OrdersEnterpriseAPIConfig;
import com.example.model.EnterpriseOrder;


	@SpringBootApplication
	//@ComponentScan(basePackages = "com.example.service")
	public class MyApplication4 {

	    public static void main(String[] args) {
	        AnnotationConfigApplicationContext context4= new AnnotationConfigApplicationContext(OrdersEnterpriseAPIConfig.class);
	        SpringApplication.run(MyApplication3.class, args);
	        EnterpriseOrder enterpriseorder=context4.getBean("orderingenterpriseBean",EnterpriseOrder.class);
	        enterpriseorder.test();
	    }
}
