package com.example.annotations.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.annotations.service.Vehicle;
import com.example.annotations.service.impl.Aeroplane;
import com.example.annotations.service.impl.Bus;
import com.example.annotations.service.impl.Car;

@Configuration
public class AppConfig {

//    @Bean("Car")
//    Vehicle getCar() {
//        return new Car();
//    }
//    
//	@Bean("Bus")
//	Vehicle getBus() {
//		return new Bus();
//	}
//	
//	@Bean("Plane")
//	@Primary
//	Vehicle getAeroplane() {
//		return new Aeroplane();
//	}
	
	@Bean
	DownStreamProperties getDownStreamProperties() {
		return new DownStreamProperties();
	}

}
