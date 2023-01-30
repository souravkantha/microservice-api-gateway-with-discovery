package com.microservice.vat.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VATRate {

		private String countryCode;
		private String country;
		private Double standardRate;
		private Double reducedRate;
      
}
