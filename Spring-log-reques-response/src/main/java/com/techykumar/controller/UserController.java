package com.techykumar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techykumar.dto.UserDtoReq;
import com.techykumar.dto.UserDtoRes;
import com.techykumar.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	ResponseEntity<UserDtoRes> addUser(@RequestBody UserDtoReq userDto){
		UserDtoRes userDtoRes = userService.addUser(userDto);
		return ResponseEntity.ok(userDtoRes);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<String> updateUser(@RequestBody UserDtoReq userDto, @PathVariable long id){
		try {
			userService.updateUser(userDto,id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body("User not found");
		}
		return ResponseEntity.ok("User updated successfully.");
	}
	
	@GetMapping
	ResponseEntity<List<UserDtoRes>> getAllUsers(){
		List<UserDtoRes> userDtoResList = userService.getAllUsers();
		return ResponseEntity.ok(userDtoResList);
	}
}
