package com.example.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.example.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Repository
public class CustomerDao {

	private static void sleepExecution(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Customer> getCustomers(int n){
		return IntStream.rangeClosed(0, n)
		.peek(CustomerDao::sleepExecution)
		.peek(i -> System.out.println("Processing ->" + i))
		.mapToObj(i-> new Customer(i,"Customer "+i))
		.toList();
	}
	
	public Flux<Customer> getCustomerStream(int n){
		return Flux.range(0, n)
		.delayElements(Duration.ofSeconds(1))
		.doOnNext(i -> System.out.println("Processing -> "+ i))
		.map(i -> new Customer(i, "Customer "+ i));
	}
	public Flux<Customer> getCustomerList(int n){
		return Flux.range(0, n)
		.doOnNext(i -> System.out.println("Processing -> "+ i))
		.map(i -> new Customer(i, "Customer "+ i));
	}
}
