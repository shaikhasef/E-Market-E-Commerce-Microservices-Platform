package com.E_market.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.E_market.entity.UserEntity;

@Repository
public interface userRepository extends JpaRepository<UserEntity, Long>{
	
	@Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :password")
	Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    public Optional<UserEntity> findByEmail(String email);
}