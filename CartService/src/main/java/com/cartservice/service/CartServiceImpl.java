package com.cartservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cartservice.dto.CartRequest;
import com.cartservice.dto.ProductResponse;
import com.cartservice.entity.CartServiceEntity;
import com.cartservice.repository.CartServiceRepository;

public class CartServiceImpl implements CartServiceProvider{
	
	   @Autowired
	    private CartServiceRepository cartRepository;

	    @Override
	    public CartServiceEntity addProduct(CartRequest request) {
             // we need to change here because product is not available message by lalit
	        ProductResponse product = getProductFromProductService(request.getProductId());

	        CartServiceEntity cart = new CartServiceEntity();
	        cart.setUserId(request.getUserId());
	        cart.setProductId(request.getProductId());
	        cart.setQuantity(request.getQuantity());

	        BigDecimal total = product.getPrice()
	                .multiply(BigDecimal.valueOf(request.getQuantity()));

	        cart.setTotalPrice(total);

	        return cartRepository.save(cart);
	    }

	    @Override
	    public List<CartServiceEntity> getCart(Long userId) {
	        return cartRepository.findByUserId(userId);
	    }

	    @Override
	    public CartServiceEntity updateQuantity(Long cartId, Integer quantity) {

	    	CartServiceEntity cart = cartRepository.findById(cartId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));

	        ProductResponse product =
	                getProductFromProductService(cart.getProductId());//product id requried

	        cart.setQuantity(quantity);

	        cart.setTotalPrice(product.getPrice()
	                .multiply(BigDecimal.valueOf(quantity)));

	        return cartRepository.save(cart);
	    }

	    @Override
	    public void removeProduct(Long cartId) {
	        cartRepository.deleteById(cartId);
	    }

	    @Override
	    public void clearCart(Long userId) {
	        cartRepository.deleteByUserId(userId);
	    }

	    @Override
	    public Integer getTotalItems(Long userId) {
	        return cartRepository.findByUserId(userId)
	                .stream()
	                .mapToInt(CartServiceEntity::getQuantity)
	                .sum();
	        
	        
	    }

	    @Override
	    public BigDecimal getTotalAmount(Long userId) {
	        return cartRepository.findByUserId(userId)
	                .stream()
	                .map(CartServiceEntity::getTotalPrice)
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	    }

	    private ProductResponse getProductFromProductService(Long productId) {
	        // Replace this with Feign Client or WebClient
	        return null;
	    }

		
	
	
}
