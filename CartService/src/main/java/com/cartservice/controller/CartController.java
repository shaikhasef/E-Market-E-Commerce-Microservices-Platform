package com.cartservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.dto.CartRequest;
import com.cartservice.entity.CartServiceEntity;
import com.cartservice.service.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	 @Autowired
	    private CartServiceImpl cartService;

	    @PostMapping
	    public ResponseEntity<CartServiceEntity> addProduct(@RequestBody CartRequest request) {
	        return ResponseEntity.ok(cartService.addProduct(request));
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<List<CartServiceEntity>> getCart(@PathVariable Long userId) {
	        return ResponseEntity.ok(cartService.getCart(userId));
	    }

	    @PutMapping("/{cartId}")
	    public ResponseEntity<CartServiceEntity> updateQuantity(
	            @PathVariable Long cartId,
	            @RequestParam Integer quantity) {

	        return ResponseEntity.ok(cartService.updateQuantity(cartId, quantity));
	    }

	    @DeleteMapping("/{cartId}")
	    public ResponseEntity<String> removeProduct(@PathVariable Long cartId) {
	        cartService.removeProduct(cartId);
	        return ResponseEntity.ok("Product removed from cart");
	    }

	    @DeleteMapping("/user/{userId}")
	    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
	        cartService.clearCart(userId);
	        return ResponseEntity.ok("Cart cleared");
	    }

	    @GetMapping("/count/{userId}")
	    public ResponseEntity<Integer> getTotalItems(@PathVariable Long userId) {
	        return ResponseEntity.ok(cartService.getTotalItems(userId));
	    }

	    @GetMapping("/total/{userId}")
	    public ResponseEntity<BigDecimal> getTotalAmount(@PathVariable Long userId) {
	        return ResponseEntity.ok(cartService.getTotalAmount(userId));
	    }
	
	
}
