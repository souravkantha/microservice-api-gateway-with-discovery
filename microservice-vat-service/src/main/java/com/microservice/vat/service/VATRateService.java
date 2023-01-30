package com.microservice.vat.service;

import java.util.List;

import com.microservice.vat.dto.VATRate;

public interface VATRateService {
	
	
	public List<VATRate> getHighestStandardVATRates(int count) throws RuntimeException ;
	
	public List<VATRate> getLowestReducedVATRates(int count) throws RuntimeException ;

}
