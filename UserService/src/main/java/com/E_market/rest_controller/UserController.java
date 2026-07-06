package com.E_market.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.E_market.entity.UserEntity;
import com.E_market.service.UserService;

@RestController
@RequestMapping("/user-api")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> getuser(@RequestBody UserEntity user) {
		String result = service.registerUser(user);

		return new ResponseEntity<String>(result,HttpStatus.OK);
	}


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntity user) {
		System.out.println("hello world");
	    String username = user.getUsername();
	    String password = user.getPassword();
		UserEntity loginUser = service.loginUser(username, password);
		if(loginUser!=null)
			return new ResponseEntity<String>("User login successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Invalid username or password",HttpStatus.BAD_REQUEST);
	}



	@GetMapping("get/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id) {
		UserEntity user = service.getUser(id);
		return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}
	@GetMapping("get-user/{email}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("email") String email) {
		UserEntity user = service.getUser(email);
		return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
	}


	@GetMapping("get-all")

	public ResponseEntity<List<UserEntity>> getall() {
		List<UserEntity> users = service.getAll();
		return new ResponseEntity<List<UserEntity>>(users,HttpStatus.OK);
	}



	@PutMapping("update-user/{id}")

	public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestBody UserEntity user) {
		String msg = service.updateUser(id,user);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}



	@DeleteMapping("delete-user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		String msg = service.deleteUser(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
}
