package com.microservice.vat.cache;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vat.dto.VATRate;
import com.microservice.vat.exceptions.CustomException;

@Component
public class ToyCache {
	
	private List<VATRate> vatStandardHighestRates = new ArrayList<>();
	private List<VATRate> vatReducedLowestRates = new ArrayList<>();

	public ToyCache() { // Fail-Fast, parsing the json
		 ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(new URL("https://euvatrates.com/rates.json"));
			JsonNode jsonNode  =  node.get("rates");
			
			Iterator<String> iterator = jsonNode.fieldNames();
			iterator.forEachRemaining(e -> {
				VATRate vatRate = new VATRate();
				vatRate.setCountryCode(e);
				vatRate.setCountry(jsonNode.get(e).get("country").asText());
				vatRate.setStandardRate(isValidDouble(jsonNode.get(e).get("standard_rate").toString()) ? 
						Double.valueOf(jsonNode.get(e).get("standard_rate").toString()) : 0.0);
				vatRate.setReducedRate(isValidDouble(jsonNode.get(e).get("reduced_rate").toString()) ? 
						Double.valueOf(jsonNode.get(e).get("reduced_rate").toString()) : 0.0);
				vatStandardHighestRates.add(vatRate);
				vatReducedLowestRates.add(vatRate);
				sort();
			});
			
				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean isValidDouble(String s) {
		
		try {
			Double.valueOf(s);
		} catch(NumberFormatException e) {
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	public void sort() {
		
		vatStandardHighestRates.sort((VATRate o1, VATRate o2) -> {
				// TODO Auto-generated method stub
				if(o1.getStandardRate() < o2.getStandardRate()) {
					return 1;
				} else if(o1.getStandardRate() > o2.getStandardRate()) {
					return -1;
				}
				
				return 0;
			}
		);
		
		vatReducedLowestRates.sort((VATRate o1, VATRate o2) -> {
			// TODO Auto-generated method stub
			if(o1.getReducedRate() > o2.getReducedRate()) {
				return 1;
			} else if(o1.getReducedRate() < o2.getReducedRate()) {
				return -1;
			}
			
			return 0;
		}
	);
		
	}
	
	public List<VATRate> getVatStandardHighestRates(int count) throws RuntimeException {
		
		if(vatReducedLowestRates.size() < count)
			throw new CustomException("ERR-001", "Actual number of countries are lesser than count");
		
		return vatStandardHighestRates.subList(0, count);
		
	}
	
	public List<VATRate> getVatReducedLowestRates(int count) throws RuntimeException {
		
		if(vatReducedLowestRates.size() < count)
			throw new CustomException("ERR-001", "Actual number of countries are lesser than count");
		
		return vatReducedLowestRates.subList(0, count);
		
	}
	

}
