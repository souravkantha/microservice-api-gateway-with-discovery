package com.microservice.vat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.vat.cache.ToyCache;
import com.microservice.vat.dto.VATRate;
import com.microservice.vat.service.VATRateService;

@Service
public class VATRateServiceImpl implements VATRateService {
	
	@Autowired
	private ToyCache cache;

	@Override
	public List<VATRate> getHighestStandardVATRates(int count) {
		// TODO Auto-generated method stub
			
			return cache.getVatStandardHighestRates(count);
		
	}

	@Override
	public List<VATRate> getLowestReducedVATRates(int count) {
		// TODO Auto-generated method stub
		return cache.getVatReducedLowestRates(count);
	}

}
