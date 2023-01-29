package com.microservice.vat.service;

import java.util.List;

import com.microservice.vat.dto.VATRate;

public interface VATRateService {
	
	
	public List<VATRate> getHighestStandardVATRates();

}
