package com.mircoservice.vat.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservice.vat.cache.ToyCache;
import com.microservice.vat.dto.VATRate;
import com.microservice.vat.exceptions.CustomException;
import com.microservice.vat.service.impl.VATRateServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VATRateServiceTest {
	
	@InjectMocks
	VATRateServiceImpl service;
	
	@Mock
	ToyCache cache;
	
	@Test
	public void testGetHighestStandardVATRates() {
		
		
		// Build mock objects for returning
		VATRate vatRateAT = new VATRate("AT", "Austria", 20.0, 10.0);
		VATRate vatRateBE = new VATRate("BE", "Belgium", 21.0, 12.0);
		
		List<VATRate> vatRates = new LinkedList<>();
		vatRates.add(vatRateAT);
		vatRates.add(vatRateBE);
		
		when(cache.getVatStandardHighestRates(1))
			.thenReturn(vatRates);
		
		List<VATRate> vatRatesResponse = service.getHighestStandardVATRates( 1 );
		
		assertThat(vatRatesResponse.size() == 1);
		assertThat(vatRatesResponse.get(0).getCountryCode().equals("BE"));
		
	}
	
	@Test
	public void testGetHighestStandardVATRatesNegative() {
		
		
		// Build mock objects for returning
		VATRate vatRateAT = new VATRate("AT", "Austria", 20.0, 10.0);
		VATRate vatRateBE = new VATRate("BE", "Belgium", 21.0, 12.0);
		
		List<VATRate> vatRates = new LinkedList<>();
		vatRates.add(vatRateAT);
		vatRates.add(vatRateBE);
		
		when(cache.getVatStandardHighestRates(3))
			.thenReturn(vatRates);
		
		service.getHighestStandardVATRates( 3 );
		
		assertThatExceptionOfType(CustomException.class);
		
	}
	
	
	
	

}
