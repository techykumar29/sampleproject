package com.myapp.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.security.dto.LoginDto;
import com.myapp.spring.security.dto.UserDto;
import com.myapp.spring.security.model.UserEntity;
import com.myapp.spring.security.service.UserService;
import com.myapp.spring.security.util.AppUtil;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AppUtil appUtil;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/signup")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto) {
		UserEntity userEntity = appUtil.mapToUserEntity(userdto);
		String encryptedPassword = bCryptPasswordEncoder.encode(userdto.getPassword());
		userEntity.setEncryptedPassword(encryptedPassword);
		
		UserEntity savedUserEntity = userService.createUser(userEntity);
		return ResponseEntity.ok(appUtil.mapToUserDto(savedUserEntity));

	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody LoginDto login){
		return ResponseEntity.ok(new UserDto());
	}
	
	@GetMapping
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("Application is working fine");
	}
}
