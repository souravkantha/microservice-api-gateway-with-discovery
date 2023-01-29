package com.microservice.vat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaClient;

@Configuration
public class GlobalConfig {
	
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
	
	@Bean
	ObjectMapper jackson2ObjectMapperBuilder() {
	    return new ObjectMapper();
	}

}
