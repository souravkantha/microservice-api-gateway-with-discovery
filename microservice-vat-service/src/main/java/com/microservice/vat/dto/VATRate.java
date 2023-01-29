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
		private String standardRate;
		private String reducedRate;
		private String reducedRateAlt;
		private String superReducedRate;
		private String parkingRate;
		private String comment;
		private String isoDuplicateOf;
      
}
