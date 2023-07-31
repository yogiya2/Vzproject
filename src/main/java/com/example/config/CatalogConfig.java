package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.CatalogAPI;

@Configuration
@ComponentScan(basePackages = "BeanAnnotation")
public class CatalogConfig { 
@Bean
public CatalogAPI CatalogBean()
{
    return new CatalogAPI();
 }

}