package com.techykumar.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateExceptionHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		if(response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
			return true;
		}
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if(response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError()) {
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))){
				String errorMsg = reader.lines().collect(Collectors.joining(","));
				throw new RestTemplateException(errorMsg, response.getStatusCode());
			}
			
		}
	
	}

}
