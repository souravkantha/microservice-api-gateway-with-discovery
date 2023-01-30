package com.mircoservice.vat.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.microservice.vat.controller.VATRateController;
import com.microservice.vat.dto.VATRate;
import com.microservice.vat.service.VATRateService;

@ExtendWith(MockitoExtension.class)
public class VATRateControllerTest {
	
	@InjectMocks
	VATRateController controller;
	
	@Mock
	VATRateService service;
	
	@Test
	public void testGetStandardHighestVATRateCountries() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		// Build mock objects for returning
		VATRate vatRateAT = new VATRate("AT", "Austria", 20.0, 10.0);
		VATRate vatRateBE = new VATRate("BE", "Belgium", 21.0, 12.0);
		
		List<VATRate> vatRates = new LinkedList<>();
		vatRates.add(vatRateAT);
		vatRates.add(vatRateBE);
		
		when(service.getHighestStandardVATRates(1))
			.thenReturn(vatRates);
		
		List<VATRate> vatRatesResponse = controller.getStandardHighestVATRateCountries("EU", 1);
		
		assertThat(vatRatesResponse.size() == 1);
		assertThat(vatRatesResponse.get(0).getCountryCode().equals("BE"));
		
	}
	
	@Test
	public void testGetLowestReducedVATRateCountries() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		// Build mock objects for returning
		VATRate vatRateAT = new VATRate("AT", "Austria", 20.0, 10.0);
		VATRate vatRateBE = new VATRate("BE", "Belgium", 21.0, 12.0);
		
		List<VATRate> vatRates = new LinkedList<>();
		vatRates.add(vatRateAT);
		vatRates.add(vatRateBE);
		
		when(service.getLowestReducedVATRates(1))
			.thenReturn(vatRates);
		
		List<VATRate> vatRatesResponse = controller.getReducedLowestVATRateCountries("EU", 1);
		
		assertThat(vatRatesResponse.size() == 1);
		assertThat(vatRatesResponse.get(0).getCountryCode().equals("AT"));
		
		
	}
	
	@Test
	public void testGetLowestReducedVATRateCountriesNegative() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		// Build mock objects for returning
		VATRate vatRateAT = new VATRate("AT", "Austria", 20.0, 10.0);
		VATRate vatRateBE = new VATRate("BE", "Belgium", 21.0, 12.0);
		
		List<VATRate> vatRates = new LinkedList<>();
		vatRates.add(vatRateAT);
		vatRates.add(vatRateBE);
		
		when(service.getLowestReducedVATRates(3))
			.thenReturn(vatRates);
		
		 controller.getReducedLowestVATRateCountries("EU", 3);
		
		assertThatRuntimeException();
		
		
	}
	

}
