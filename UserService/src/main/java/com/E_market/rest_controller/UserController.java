package com.E_market.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.E_market.entity.UserEntity;
import com.E_market.repository.userRepository;
import com.E_market.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("add")
	public String getuser(@RequestBody UserEntity u) {
		
		return "working";
	}
	@GetMapping("get")
	public List<UserEntity> getall() {
		return null;
	}
}
