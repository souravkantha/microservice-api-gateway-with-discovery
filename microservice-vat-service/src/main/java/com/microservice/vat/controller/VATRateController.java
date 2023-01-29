package com.microservice.vat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.vat.dto.VATRate;
import com.microservice.vat.service.VATRateService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/vat/rates", produces = MediaType.APPLICATION_JSON_VALUE)
public class VATRateController {
	
	@Value("${server.port}")
	private int serverPort;

	@Autowired
	private VATRateService vatRateService;
	
	//@GetMapping("/{continent-code}/standard-high/{count}")
	@GetMapping("/standard/highest")
	public List<VATRate> getHighestStandardVATRates(
			@Parameter(description = "Optional, continent value to be passed")  @RequestParam(name = "continent", required = false, defaultValue = "EU") String continent,
			@Parameter(description = "Optional, provide number of countries to be fetched")  @RequestParam(name = "count", required = false, defaultValue = "3") Integer count ) {
		
		
		log.info("Serving from port : " + serverPort);
		return vatRateService.getHighestStandardVATRates();
		
	}
	
}
