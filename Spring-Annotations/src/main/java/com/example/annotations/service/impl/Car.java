package com.example.annotations.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.annotations.service.Vehicle;

@Component
@Qualifier("Car")
public class Car implements Vehicle{
	
	Logger logger = LoggerFactory.getLogger(Car.class);

	@Override
	public void move() {
		logger.info("Going to my destination > Car");
		
	}
	
}
