package com.E_market.service;

import java.util.List;

import com.E_market.entity.UserEntity;

public interface UserService {
	public String registerUser(UserEntity user);
	public UserEntity loginUser(String username,String password);
	public UserEntity getUser(Long id);
	public UserEntity getUser(String email);
	public List<UserEntity> getAll();
	public String updateUser(Long id,UserEntity user);
	public String deleteUser(Long id);
}