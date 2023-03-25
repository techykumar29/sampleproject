package com.example.filter.filters.approac1;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
@Order(1)
public class MyFilter1 implements Filter{
	Logger LOGGER = LoggerFactory.getLogger(MyFilter1.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.info("My Filter 1 is intercepted");
//		PrintWriter writer = response.getWriter();
//		writer.write("This request is intercepted by Filter1");
		chain.doFilter(request, response);
		
	}

}
