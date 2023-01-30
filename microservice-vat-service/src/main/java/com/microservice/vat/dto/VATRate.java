package com.microservice.vat.dto;



import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
		@JsonInclude(Include.NON_NULL)
		private String reducedRateAlt;
		@JsonInclude(Include.NON_NULL)
		private String superReducedRate;
		@JsonInclude(Include.NON_NULL)
		private String parkingRate;
		@JsonInclude(Include.NON_NULL)
		private String comment;
		@JsonInclude(Include.NON_NULL)
		private String isoDuplicateOf;
      
}
