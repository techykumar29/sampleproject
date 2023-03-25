package com.multiple.datasource.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiple.datasource.config.PaymentDataSource;
import com.multiple.datasource.dto.OrderDetailsDto;
import com.multiple.datasource.dto.PaymentDetailsDto;
import com.multiple.datasource.entity.orders.OrderDetails;
import com.multiple.datasource.entity.payment.PaymentDetails;
import com.multiple.datasource.repository.order.OrderRepository;
import com.multiple.datasource.repository.payment.PaymentRepository;

@RestController
@RequestMapping(value = "/multidb")
public class AppController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/order")
	public ResponseEntity<OrderDetails> saveOrderDetails(@RequestBody OrderDetailsDto request){
		
		OrderDetails entity = modelMapper.map(request, OrderDetails.class);
		return ResponseEntity.ok(orderRepo.save(entity));
	}
	
	@PostMapping("/payment")
	public ResponseEntity<String> saveOrderDetails(@RequestBody PaymentDetailsDto request){
		
		PaymentDetails entity = modelMapper.map(request, PaymentDetails.class);
		paymentRepo.save(entity);
		return ResponseEntity.ok("Payment details saved successfully");
	}
	
	@GetMapping("/orders")
	public List<OrderDetails> getOrders(){
		return orderRepo.getOrderList();
	}
	

}
