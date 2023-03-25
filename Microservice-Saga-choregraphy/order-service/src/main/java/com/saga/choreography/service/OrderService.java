package com.saga.choreography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.choreography.entity.PurchaseOrder;
import com.saga.choreography.repository.OrderRepository;

import commondtos.saga.dto.OrderRequestDto;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
		return orderRepository.save(null);
	}

}
