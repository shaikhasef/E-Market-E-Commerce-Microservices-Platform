package com.E_market.rest_controller;

import java.util.List;

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

import com.E_market.entity.UserEntity;
import com.E_market.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("rgister")
	public ResponseEntity<String> getuser(@RequestBody UserEntity u) {
		String result = service.registerUser(u);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntity user) {
	    String username = user.getUsername();
	    String password = user.getPassword();
		UserEntity loginUser = service.loginUser(username, password);
		if(loginUser!=null)
			return new ResponseEntity<String>("User login successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Invlid username or password",HttpStatus.BAD_REQUEST);
	}
	@GetMapping("getuser/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id) {
		UserEntity user = service.getUser(id);
		return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	@GetMapping("getall")
	public ResponseEntity<List<UserEntity>> getall() {
		List<UserEntity> users = service.getAll();
		return new ResponseEntity<List<UserEntity>>(users,HttpStatus.OK);
	}
	@PutMapping("updateuser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody UserEntity user) {
		String msg = service.updateUser(id,user);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("deletteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		String msg = service.deleteUser(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
