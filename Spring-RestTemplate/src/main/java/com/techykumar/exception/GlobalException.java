package com.techykumar.exception;

import java.security.cert.CertPathValidatorException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(RestTemplateException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String restTemplateException(RestTemplateException restEx) {
		return restEx.getError()+"Rest Template";
	}
	
	@ExceptionHandler(MismatchedInputException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String mismatchException(MismatchedInputException restEx) {
		restEx.printStackTrace();
		return restEx.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String resourceAccessException(Exception restEx) {
		restEx.printStackTrace();
		return restEx.getMessage()+"Exception Handled";
	}

}
