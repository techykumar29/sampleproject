package com.example.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.webflux.dao.CustomerDao;
import com.example.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
	
	@Autowired
	CustomerDao customerDao;
	
	public Mono<ServerResponse> getCustomers(ServerRequest request){
		Flux<Customer> customers = customerDao.getCustomerStream(10);
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(customers,Customer.class);
	}

}
