package com.microservice.vat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VATRate {

	   public String country;
       public Double standardRate;
       public Double reducedRate;
      
}
