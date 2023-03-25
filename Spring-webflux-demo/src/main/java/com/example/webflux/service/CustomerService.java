package com.example.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webflux.dao.CustomerDao;
import com.example.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<Customer> loadAllCustomers() {
		return customerDao.getCustomers(15);
	}

	public Flux<Customer> loadAllCustomerStream() {
		return customerDao.getCustomerStream(15);
	}

}
