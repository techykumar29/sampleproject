package com.example.annotations.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.annotations.service.Vehicle;

@Component
@Qualifier("Bus")
public class Bus implements Vehicle{
	
	Logger logger = LoggerFactory.getLogger(Bus.class);

	@Override
	public void move() {
		logger.info("Going to my destination by > Bus");
		
	}
	
}
