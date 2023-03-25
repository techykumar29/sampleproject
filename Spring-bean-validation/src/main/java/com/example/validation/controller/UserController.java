package com.example.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.dto.UserRequest;
import com.example.validation.entity.User;
import com.example.validation.exception.ResourceNotFoundException;
import com.example.validation.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> saveUser( @Valid @RequestBody UserRequest userRequest){
		return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id){
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@PostMapping("/updatePhoneNumber/{id}/{phone}")
	public ResponseEntity<String> updatePhoneNumber(@PathVariable long id,@PathVariable String phone){
		int rowUpdated = userService.updatePhoneNumber(id,phone);
		if(rowUpdated > 0) {
			return new ResponseEntity<String>("Phone number updated",HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("Phone number not updated",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @Valid @RequestBody UserRequest userRequest) throws ResourceNotFoundException{
		return new ResponseEntity<User>(userService.updateUser(id,userRequest),HttpStatus.OK);
	}

}
