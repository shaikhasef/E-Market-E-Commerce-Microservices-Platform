package com.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.cartservice.entity.CartServiceEntity;

public interface CartServiceRepository extends JpaRepository<CartServiceEntity, Long> {

	 List<CartServiceEntity> findByUserId(Long userId);

	    long countByUserId(Long userId);

	    void deleteByUserId(Long userId);
	
}
