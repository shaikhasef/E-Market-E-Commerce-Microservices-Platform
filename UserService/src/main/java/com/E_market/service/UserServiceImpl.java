package com.E_market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_market.entity.UserEntity;
import com.E_market.repository.userRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public userRepository userRepo;

	@Override
	public String registerUser(UserEntity user) {
		try {
			user.setId(userRepo.getLastId().orElse(1000l)+1);
			System.out.print(user.toString());
			 userRepo.save(user);
		} catch (Exception e) {
			System.out.print(e.toString());
			return "Exception Occure in user creation ";
		}
		return "user created successfully.";
	}

	
	@Override
	public UserEntity loginUser(String username, String password) {
		
			
		   return userRepo.findByUsernameAndPassword(username, password)
		            .orElse(null);
	}

	@Override
	public UserEntity getUser(Long id) {
		Optional<UserEntity> user = userRepo.findById(id);
		return user.orElseThrow(() -> new RuntimeException("Invalid Id!"));
	}

	@Override
	public UserEntity getUser(String email) {
		Optional<UserEntity> user = userRepo.findByEmail(email);
		return user.orElseThrow(() -> new RuntimeException("User not found with email: " + email));
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
