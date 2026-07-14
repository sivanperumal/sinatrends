package com.javacode.sinatrends.dto;

import java.util.List;

import com.javacode.sinatrends.entity.Product;

public class WishlistResponse {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
