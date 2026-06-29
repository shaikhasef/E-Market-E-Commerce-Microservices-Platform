package com.E_market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_market.entity.UserEntity;
import com.E_market.repository.userRepository;




public class UserServiceImpl implements UserService{
	
	@Autowired
	public userRepository userRepo;

	@Override
	public String registerUser(UserEntity user) {
		try {
			 userRepo.save(user);
		} catch (Exception e) {
			return "Exception Occure in user creation ";
		}
		return "user created successfully.";
	}

	@Override
	public UserEntity loginUser(String username, String password) {
		
			UserEntity loginedUser = userRepo.findByUsernameAndPassword(username, password);
		
		    return loginedUser;
	}

	@Override
	public UserEntity getUser(Long id) {
		Optional<UserEntity> user = userRepo.findById(id);
		return user.get();
	}

	@Override
	public List<UserEntity> getAll() {
		
		return userRepo.findAll();
	}

	@Override
	public String updateUser(Long id,UserEntity user) {
		try {
			user.setId(id);
			 userRepo.save(user);
		} catch (Exception e) {
			return "Exception Occure in user updation ";
		}
		return "user updated successfully.";
	}

	@Override
	public String deleteUser(Long id) {
		try {
			 userRepo.deleteById(id);;
		} catch (Exception e) {
			return "Exception Occure in user deletion ";
		}
		return "user deleted successfully.";
	}

}
