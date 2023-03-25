package com.example.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.webflux.dao.CustomerDao;
import com.example.webflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	@Autowired
	CustomerDao customerDao;
	
	public Mono<ServerResponse> loadCustomers(ServerRequest request){
		Flux<Customer> customers = customerDao.getCustomerList(10);
		return ServerResponse.ok().body(customers,Customer.class);
	}
	
	public Mono<ServerResponse> findCustomer(ServerRequest request){
		int customerId = Integer.parseInt(request.pathVariable("input"));
		Mono<Customer> customer = customerDao.getCustomerList(10).filter(e -> e.getId() == customerId).next();
		return ServerResponse.ok().body(customer,Customer.class);
	}
	
	public Mono<ServerResponse> saveCustomer(ServerRequest request){
		Mono<Customer> customer = request.bodyToMono(Customer.class); 
		Mono<String> saveRes = customer.map(dto-> dto.getName()+":"+dto.getId());
		return ServerResponse.ok().body(saveRes,String.class);
	}
}
