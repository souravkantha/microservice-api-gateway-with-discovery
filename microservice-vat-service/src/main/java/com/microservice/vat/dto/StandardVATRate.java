package com.microservice.vat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardVATRate {

		private String country;
		private Double standardRate;
      
}
