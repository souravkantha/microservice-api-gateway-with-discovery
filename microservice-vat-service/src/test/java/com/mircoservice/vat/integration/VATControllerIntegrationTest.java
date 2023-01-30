package com.mircoservice.vat.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.microservice.vat.MicroserviceVatApplication;
import com.microservice.vat.dto.VATRate;

@SpringBootTest(classes = MicroserviceVatApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class VATControllerIntegrationTest {
	
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void testGetStandardHighestVATRateCountriesAPISanity() {
		
		ResponseEntity<VATRate[]> responseEntity = 
				this.restTemplate.getForEntity("http://localhost:" + port + "/vat/rates/reduced/lowest", VATRate[].class);
		
		assertEquals(200, responseEntity.getStatusCode().value());
		
	}
	
	
	@Test
	public void testGetStandardHighestVATRateCountriesAPI() {
		
		ResponseEntity<VATRate[]> responseEntity = 
				this.restTemplate.getForEntity("http://localhost:" + port + "/vat/rates/reduced/lowest?count={count}", VATRate[].class, 3);
		
		assertEquals(200, responseEntity.getStatusCode().value());
		assertEquals(3, responseEntity.getBody().length);
		
	}
	
	@Test
	public void testGetStandardHighestVATRateCountriesAPINegative() {
		
		ResponseEntity<?> responseEntity = 
				this.restTemplate.getForEntity("http://localhost:" + port + "/vat/rates/reduced/lowest?count={count}", Object.class, 10000);
		
		
		assertEquals(404, responseEntity.getStatusCode().value());
		
	}
}
