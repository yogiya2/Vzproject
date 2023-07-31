package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.EnterpriseOrder;




	@Configuration
	@ComponentScan(basePackages = "BeanAnnotation")
	public class OrdersEnterpriseAPIConfig {
	@Bean
	public EnterpriseOrder orderingenterpriseBean()
	{
	    return new EnterpriseOrder();
	 }

	
}