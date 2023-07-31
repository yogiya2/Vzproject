package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.ServiceService;





	@Configuration
	@ComponentScan(basePackages = "BeanAnnotation")
	public class SercviceAPIConfig {
	@Bean
	public ServiceService serviceBean()
	{
	    return new ServiceService();
	 }

	}


