package com.example.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.webflux.handler.CustomerHandler;
import com.example.webflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {
	
	@Autowired
	CustomerHandler customerHandler;
	
	@Autowired
	CustomerStreamHandler customerStreamHandler;
	
	@Bean
	RouterFunction<ServerResponse> routerFunction(){
		return RouterFunctions.route()
				.GET("/router/customers", customerHandler::loadCustomers)
				.GET("/router/customers/stream", customerStreamHandler::getCustomers)
				.GET("/router/customers/{input}", customerHandler::findCustomer)
				.POST("/router/customers/save",customerHandler::saveCustomer)
				.build();
	}

}
