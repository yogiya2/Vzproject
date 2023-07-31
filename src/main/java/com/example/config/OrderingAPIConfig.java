package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.Order;




	@Configuration
	@ComponentScan(basePackages = "BeanAnnotation")
	public class OrderingAPIConfig {	
	@Bean
	public Order OrderBean()
	{
	    return new Order();
	 }

	}




