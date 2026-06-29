package com.E_market.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.E_market.entity.UserEntity;

public interface userRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByUsernameAndPassword(String username, String password);

}
