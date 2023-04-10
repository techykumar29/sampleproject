package com.techykumar.exception;

import org.springframework.http.HttpStatusCode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestTemplateException extends RuntimeException{
	
	private String error;
	private HttpStatusCode statusCode;
	
	public RestTemplateException(String error,HttpStatusCode httpStatusCode) {
		super(error);
		this.error = error;
		this.statusCode = httpStatusCode;
		
	}

}
