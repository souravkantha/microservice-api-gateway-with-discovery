package com.microservice.vat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GlobalConfig {
	
	@Bean
	ObjectMapper jackson2ObjectMapperBuilder() {
	    return new ObjectMapper();
	}

}
