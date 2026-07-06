package com.E_market.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_market.entity.Category;
import com.E_market.entity.ProductEntity;
import com.E_market.service.ProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductEntity product){
		String result = service.addProduct(product);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	@GetMapping("/get-all")
	public ResponseEntity<List<ProductEntity>> getAll(){
		List<ProductEntity> list = service.getAll();
		return new ResponseEntity<List<ProductEntity>>(list,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductEntity> getById(@PathVariable("id") Long id){
		ProductEntity product = service.getById(id);
		return new ResponseEntity<ProductEntity>(product,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") Long id,
			                                    @RequestBody ProductEntity product){
		String result = service.updateProduct(id,product);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
		String result = service.deleteProduct(id);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<ProductEntity>> getByCategory(@PathVariable("category") Category category){
		
		List<ProductEntity> list = service.getByCategory(category);
		return new ResponseEntity<List<ProductEntity>>(list,HttpStatus.OK);
	}
	@GetMapping("/search/{name}")
	public ResponseEntity<List<ProductEntity>> getByName(@PathVariable("name") String name){
		List<ProductEntity> list = service.getProducts(name);
		return new ResponseEntity<List<ProductEntity>>(list,HttpStatus.OK);
	}
	@GetMapping("/low-to-high")
	public ResponseEntity<List<ProductEntity>> lowToHigh(){
		List<ProductEntity> list = service.lowToHigh();
		return new ResponseEntity<List<ProductEntity>>(list,HttpStatus.OK);
	}
	@GetMapping("/high-to-low")
	public ResponseEntity<List<ProductEntity>> highToLow(){
		List<ProductEntity> list = service.hightoLow();
		return new ResponseEntity<List<ProductEntity>>(list,HttpStatus.OK);
	}
	

}
