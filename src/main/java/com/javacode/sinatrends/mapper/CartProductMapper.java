package com.javacode.sinatrends.mapper;

import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.CartProductResponse;
import com.javacode.sinatrends.entity.Cart;

@Component
public class CartProductMapper {
	public CartProductResponse toDto(Cart cart, Integer quantity, Long cartId){
		CartProductResponse dto = new CartProductResponse();
		dto.setId(cartId);
		dto.setProductId(cart.getProduct().getId());
		dto.setName(cart.getProduct().getName());
		dto.setSlug(cart.getProduct().getSlug());
		dto.setBasePrice(cart.getProduct().getBasePrice());
		dto.setSalePrice(cart.getProduct().getSalePrice());
		dto.setQuantity(quantity);
		dto.setTotal(cart.getProduct().getBasePrice() * quantity);
		dto.setDiscountPercentage(Math.round(cart.getProduct().getOffer()) / 100.0);
		dto.setDiscountedPrice(cart.getProduct().getSalePrice() * quantity);
		String thumbnailUrl = cart.getProduct().getImages().stream()
			    .filter(image -> Boolean.TRUE.equals(image.getThumbnail())) 
			    .map(image -> image.getImageUrl())                         
			    .findFirst()                                                
			    .orElse("default-image-url.jpg"); 
		dto.setThumbnail(thumbnailUrl);
		dto.setCreatedAt(cart.getCreatedAt());
		dto.setUpdatedAt(cart.getUpdatedAt());
		return dto;
	}
}
