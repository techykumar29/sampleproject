package com.example.validation.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.validation.dao.UserRepository;
import com.example.validation.dto.UserRequest;
import com.example.validation.entity.User;
import com.example.validation.exception.ResourceNotFoundException;
import com.example.validation.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getAge(), userRequest.getEmail(), userRequest.getPhone());
		user = userDao.save(user);
		return user;
	}

	@Override
	public User getUser(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int updatePhoneNumber(long id, String phone) {
		
		return userDao.updatePhoneNumber(id, phone);
	}

	@Override
	public User updateUser(long id, @Valid UserRequest userRequest) throws ResourceNotFoundException {
		User user = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resource not found."));
		user = convertToUser(userRequest);
		user.setId(id);
		return userDao.save(user);
	}

	private User convertToUser(UserRequest userRequest) {
		return mapper.map(userRequest, User.class);
	}
}
