package com.microservice.vat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {
	
	private String errorCode;
	
	public CustomException(final String errorCode, final String message) {
		super(message);
		this.errorCode = errorCode;
	}

}
