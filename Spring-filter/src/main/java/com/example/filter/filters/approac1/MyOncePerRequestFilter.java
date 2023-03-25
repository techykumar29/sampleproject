package com.example.filter.filters.approac1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyOncePerRequestFilter extends OncePerRequestFilter {
	
	Logger logger = LoggerFactory.getLogger(MyOncePerRequestFilter.class);
	Map<String,String> headerMap = new HashMap<>();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("Inside once per request filter");
		
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
		filterChain.doFilter(requestWrapper, responseWrapper);
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String key = headers.nextElement();
			headerMap.put(key, request.getHeader(key));
		}
		byte[] requestdata = requestWrapper.getContentAsByteArray();
		byte[] responsedata = responseWrapper.getContentAsByteArray();
		String requestBody = getValueAsString(requestdata, requestWrapper.getCharacterEncoding());
		String responseBody = getValueAsString(responsedata, responseWrapper.getCharacterEncoding());
		logger.info("Request: {}",requestBody);
		logger.info("Response: {}; Headers: {};", responseBody,headerMap);
		logger.info("Request URI:{}",request.getPathInfo());
		logger.info("Request URI:{}",request.getServletPath());
		logger.info("Request URI:{}",request.getRequestURI());
		logger.info("Request URI:{}",request.getPathInfo());
		
		responseWrapper.copyBodyToResponse();
	}
	
	private String getValueAsString(byte[] data, String encoding) {
		String outputAsString = "";
		try {
			outputAsString = new String(data,encoding);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return outputAsString;
	}

}
