package com.javacode.sinatrends.dto;

public class CartRequestDto {
	private Long userId;
	private CartProductDto product;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public CartProductDto getProduct() {
		return product;
	}
	public void setProduct(CartProductDto product) {
		this.product = product;
	}
}
