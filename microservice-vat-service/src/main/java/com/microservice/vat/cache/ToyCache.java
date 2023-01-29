package com.microservice.vat.cache;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vat.dto.VATRate;

@Component
public class ToyCache {
	
	private List<VATRate> vatRates = new LinkedList<>();

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
				vatRate.setComment(!Objects.nonNull(jsonNode.get(e).get("_comment")) ? null : jsonNode.get(e).get("_comment").toString());
				vatRate.setIsoDuplicateOf(!Objects.nonNull(jsonNode.get(e).get("iso_duplicate_of")) ? null : jsonNode.get(e).get("iso_duplicate_of").toString());
				vatRate.setStandardRate(jsonNode.get(e).get("standard_rate").toString());
				vatRate.setReducedRate(jsonNode.get(e).get("reduced_rate").toString());
				vatRates.add(vatRate);
				
			});
			
				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<VATRate> getVatRates() {
		
		return vatRates;
		
	}
	

}
