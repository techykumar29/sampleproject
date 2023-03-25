package com.prabhakar.insurance.provider;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/insurance-provider")
public class MsInsuranceProviderApplication {
	
	
	@GetMapping("/getPlans")
	List<String> getAllPlans(){
		return Stream.of("Silver","Gold","Platinum").toList();
	}

	public static void main(String[] args) {
		SpringApplication.run(MsInsuranceProviderApplication.class, args);
		
		
	}
	
	

}
