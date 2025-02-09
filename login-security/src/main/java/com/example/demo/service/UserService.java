package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.LoginMapper;

@Service
public class UserService{
	private final LoginMapper mapper;
	
	public UserService(LoginMapper mapper) {
		this.mapper = mapper;
	}
	
	public User findUserByUsername(String username) {
		return mapper.selectUserByName(username);
	}
	
	public void createUser(User user) {
		mapper.insertUser(user);
	}
}
