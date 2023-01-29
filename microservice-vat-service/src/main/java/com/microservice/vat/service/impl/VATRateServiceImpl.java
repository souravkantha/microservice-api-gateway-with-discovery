package com.microservice.vat.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.vat.dto.VATRate;
import com.microservice.vat.service.VATRateService;

@Service
public class VATRateServiceImpl implements VATRateService {

	@Override
	public List<VATRate> getHighestStandardVATRates() {
		// TODO Auto-generated method stub
			
			
			VATRate vatRate = new VATRate("Austria", 20.00, 10.00);
			
			List<VATRate> result = new LinkedList<>();
			
			result.add(vatRate);
			
			return result;
			
		
	}

}
