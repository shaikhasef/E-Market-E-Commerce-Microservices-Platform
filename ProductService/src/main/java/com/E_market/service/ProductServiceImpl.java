package com.E_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_market.entity.Category;
import com.E_market.entity.ProductEntity;
import com.E_market.repository.ProductRepositry;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepositry repo;

	@Override
	public String addProduct(ProductEntity product) {
		try {
		product.setId(repo.getLastId().orElse(2000l)+1);
		repo.save(product);
		return "Product Added Successfully";
		}catch (Exception e) {
			return "Product not Added";
		}
		
	}

	@Override
	public List<ProductEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public ProductEntity getById(Long id) {
		ProductEntity product = repo.findById(id).orElse(null);
		return product;
	}

	@Override
	public String updateProduct(Long id, ProductEntity product) {
		try {
		product.setId(id);
		repo.save(product);
		return "Product Updated Successfully";
	}catch (Exception e) {
		return "Product not Updated";
	}
	}

	@Override
	public String deleteProduct(Long id) {
		
		try {
			repo.deleteById(id);
			return "Product Deleted Successfully";
		}catch (Exception e) {
			return "Product not Deleted";
		}
	}

	@Override
	public List<ProductEntity> getByCategory(Category category) {
		return repo.findByCategory(category);
	}

	@Override
	public List<ProductEntity> getProducts(String name) {
		return repo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<ProductEntity> lowToHigh() {
		return repo.findAllByOrderByPriceAsc();
	}

	@Override
	public List<ProductEntity> hightoLow() {
		return repo.findAllByOrderByPriceDesc();
	}

}
