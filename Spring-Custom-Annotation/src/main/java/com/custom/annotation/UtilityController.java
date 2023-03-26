package com.custom.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UtilityController {
	
	@Autowired
	Utility test;

	@GetMapping
	public ResponseEntity<Map<Integer,Integer>> test(){
		return ResponseEntity.ok(test.getSquares(20));
	}
}
