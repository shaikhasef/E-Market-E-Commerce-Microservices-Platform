package com.cartservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cartservice.dto.CartRequest;
import com.cartservice.entity.CartServiceEntity;

public interface CartServiceProvider {
	
	CartServiceEntity addProduct(CartRequest request);

    List<CartServiceEntity> getCart(Long userId);

    CartServiceEntity updateQuantity(Long cartId, Integer quantity);

    void removeProduct(Long cartId);

    void clearCart(Long userId);

    Integer getTotalItems(Long userId);

    BigDecimal getTotalAmount(Long userId);

	
}
