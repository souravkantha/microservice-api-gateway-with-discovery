package com.microservice.vat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReducedVATRate {

		private String country;
		private Double reducedRate;
      
}
