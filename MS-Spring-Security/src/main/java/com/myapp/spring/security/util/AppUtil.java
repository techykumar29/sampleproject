package com.myapp.spring.security.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.spring.security.dto.UserDto;
import com.myapp.spring.security.model.UserEntity;

@Component
public class AppUtil {
	
	@Autowired
	ModelMapper modelMapper;
	
	public UserEntity mapToUserEntity(UserDto userDto) {
		return modelMapper.map(userDto, UserEntity.class);
	}
	
	public UserDto mapToUserDto(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDto.class);
	}

}
