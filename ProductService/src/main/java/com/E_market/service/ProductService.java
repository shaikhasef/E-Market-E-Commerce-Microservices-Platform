package com.E_market.service;

import java.util.List;

import com.E_market.entity.Category;
import com.E_market.entity.ProductEntity;

public interface ProductService {
	
	public String addProduct(ProductEntity product);

	public List<ProductEntity> getAll();

	public ProductEntity getById(Long id);

	public String updateProduct(Long id, ProductEntity product);

	public String deleteProduct(Long id);

	public List<ProductEntity> getByCategory(Category category);
	
	public List<ProductEntity> getProducts(String name);
	
	public List<ProductEntity> lowToHigh();
	
	public List<ProductEntity> hightoLow();

}
