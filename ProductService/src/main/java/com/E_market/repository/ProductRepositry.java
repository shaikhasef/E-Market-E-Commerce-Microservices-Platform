package com.E_market.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.E_market.entity.Category;
import com.E_market.entity.ProductEntity;

@Repository
public interface ProductRepositry extends JpaRepository<ProductEntity, Long>{

	@Query("SELECT MAX(u.id) FROM ProductEntity u")
	Optional<Long> getLastId();
	
	List<ProductEntity> findByCategory(Category category);
	
	List<ProductEntity> findByNameContainingIgnoreCase(String name);
	
	List<ProductEntity> findAllByOrderByPriceAsc();

	List<ProductEntity> findAllByOrderByPriceDesc();

}
