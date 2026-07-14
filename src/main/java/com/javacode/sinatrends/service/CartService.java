package com.javacode.sinatrends.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.*;
import com.javacode.sinatrends.entity.*;
import com.javacode.sinatrends.mapper.CartProductMapper;
import com.javacode.sinatrends.repository.*;

@Service
public class CartService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private CartProductMapper cartProductMapper;
	
	public CartResponse addCartByUser(CartRequestDto cartRequest) {
		// TODO Auto-generated method stub
		Users user = userRepo.findById(cartRequest.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
		
		Boolean exists = cartRepo.existsByUserIdAndProductId(user.getId(),cartRequest.getProduct().getId());
		if(!exists) {
			Product product = productRepo.findById(cartRequest.getProduct().getId()).orElseThrow(()-> new RuntimeException("Product not found"));
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(cartRequest.getProduct().getQuantity());
			cart.setUser(user);
			cartRepo.save(cart);
		}
		else {
			Cart cart = cartRepo.findByUserIdAndProductId(user.getId(),cartRequest.getProduct().getId()).orElseThrow(()-> new RuntimeException("Cart not found"));
			cart.setQuantity(cart.getQuantity() + cartRequest.getProduct().getQuantity());
			cart.setUpdatedAt(LocalDateTime.now());
			cartRepo.save(cart);
		}
		
		List<Cart> items = cartRepo.findByUserId(user.getId());
		List<CartProductResponse> cartProducts = items.stream().map(cart->{
			CartProductResponse productDto = cartProductMapper.toDto(cart,cart.getQuantity(), cart.getId());
			return productDto;
		}).collect(Collectors.toList());
		
		Double total =  items.stream()
				.mapToDouble(cart -> cart.getProduct().getBasePrice() * cart.getQuantity())
				.sum();
		
		Double discountedTotal =  items.stream()
			.mapToDouble(cart -> cart.getProduct().getSalePrice() * cart.getQuantity())
			.sum();
		
		Integer totalQuantity =  (int) items.stream()
				.mapToDouble(cart -> cart.getQuantity())
				.sum();
		
		CartResponse cartResponse = new CartResponse(cartProducts,total,discountedTotal,user.getId(),cartProducts.size(),totalQuantity);
		
		return cartResponse;
		
	}

	public CartResponse getCartByUser(Long user_id) {
		// TODO Auto-generated method stub
		Users user = userRepo.findById(user_id).orElseThrow(()-> new RuntimeException("User not found"));
		
		List<Cart> items = cartRepo.findByUserId(user_id);
		
		List<CartProductResponse> cartProducts = items.stream().map(cart->{
			CartProductResponse productDto = cartProductMapper.toDto(cart,cart.getQuantity(), cart.getId());
			return productDto;
		}).collect(Collectors.toList());
		
		Double total =  items.stream()
				.mapToDouble(cart -> cart.getProduct().getBasePrice() * cart.getQuantity())
				.sum();
		
		Double discountedTotal =  items.stream()
			.mapToDouble(cart -> cart.getProduct().getSalePrice() * cart.getQuantity())
			.sum();
		
		Integer totalQuantity =  (int) items.stream()
				.mapToDouble(cart -> cart.getQuantity())
				.sum();
		
		CartResponse cartResponse = new CartResponse(cartProducts,total,discountedTotal,user.getId(),cartProducts.size(),totalQuantity);
		
		return cartResponse;
	}

	
	public CartResponse updateCartByUserId(Long cart_id,Long user_id, Integer quantity) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findById(cart_id).orElseThrow(()-> new RuntimeException("Cart not found"));
		cart.setQuantity(quantity);
		cart.setUpdatedAt(LocalDateTime.now());
	    cartRepo.save(cart);

	    List<Cart> items = cartRepo.findByUserId(user_id);
		List<CartProductResponse> cartProducts = items.stream().map(product->{
			CartProductResponse productDto = cartProductMapper.toDto(product,product.getQuantity(), product.getId());
			return productDto;
		}).collect(Collectors.toList());
		
		Double total =  items.stream()
				.mapToDouble(product -> product.getProduct().getBasePrice() * product.getQuantity())
				.sum();
		
		Double discountedTotal =  items.stream()
			.mapToDouble(product -> product.getProduct().getSalePrice() * product.getQuantity())
			.sum();
		
		Integer totalQuantity =  (int) items.stream()
				.mapToDouble(product -> product.getQuantity())
				.sum();
		
		CartResponse cartResponse = new CartResponse(cartProducts,total,discountedTotal,user_id,cartProducts.size(),totalQuantity);
		
		return cartResponse;
	}

	public CartResponse removeCartByCartId(Long cart_id,Long user_id) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findById(cart_id).orElseThrow(()-> new RuntimeException("Cart not found"));
		cartRepo.delete(cart);
		
		List<Cart> items = cartRepo.findByUserId(user_id);
		List<CartProductResponse> cartProducts = items.stream().map(product->{
			CartProductResponse productDto = cartProductMapper.toDto(product,product.getQuantity(), product.getId());
			return productDto;
		}).collect(Collectors.toList());
		
		Double total =  items.stream()
				.mapToDouble(product -> product.getProduct().getBasePrice() * product.getQuantity())
				.sum();
		
		Double discountedTotal =  items.stream()
			.mapToDouble(product -> product.getProduct().getSalePrice() * product.getQuantity())
			.sum();
		
		Integer totalQuantity =  (int) items.stream()
				.mapToDouble(product -> product.getQuantity())
				.sum();
		
		CartResponse cartResponse = new CartResponse(cartProducts,total,discountedTotal,user_id,cartProducts.size(),totalQuantity);
		
		return cartResponse;
		
	}

}
