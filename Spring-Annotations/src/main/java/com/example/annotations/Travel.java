package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.annotations.service.Vehicle;

import jakarta.annotation.PostConstruct;

@Component
public class Travel {
	
	@Autowired
	@Qualifier("Bus")
	Vehicle vehicle;
	
	
	@PostConstruct
	void execute() {
		vehicle.move();
	}

}
