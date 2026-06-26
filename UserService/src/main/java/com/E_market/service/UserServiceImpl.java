package com.E_market.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_market.repository.userRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	public userRepository userRepo;

}
