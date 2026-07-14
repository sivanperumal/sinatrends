package com.javacode.sinatrends.dto;

import java.util.List;

public class CartResponse {
	private List<CartProductResponse> products;
	private Double total;
	private Double discountedTotal;
	private Long userId;
	private Integer totalProducts;
	private Integer totalQuantity;
	
	public CartResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartResponse(List<CartProductResponse> products, Double total, Double discountedTotal, Long userId, Integer totalProducts,
			Integer totalQuantity) {
		super();
		this.products = products;
		this.total = total;
		this.discountedTotal = discountedTotal;
		this.userId = userId;
		this.totalProducts = totalProducts;
		this.totalQuantity = totalQuantity;
	}

	public List<CartProductResponse> getProducts() {
		return products;
	}

	public void setProducts(List<CartProductResponse> products) {
		this.products = products;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDiscountedTotal() {
		return discountedTotal;
	}

	public void setDiscountedTotal(Double discountedTotal) {
		this.discountedTotal = discountedTotal;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	
	
}
