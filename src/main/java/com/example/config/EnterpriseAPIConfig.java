
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import com.example.model.EnterpriseCustomer;

@Configuration
@ComponentScan(basePackages = "BeanAnnotation")
public class EnterpriseAPIConfig  { 
@Bean
public EnterpriseCustomer enterpriseBean()
{
    return new EnterpriseCustomer();
 }

}