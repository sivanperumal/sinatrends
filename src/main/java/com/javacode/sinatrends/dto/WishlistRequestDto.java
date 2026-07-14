package com.javacode.sinatrends.dto;

import java.util.List;

public class WishlistRequestDto {
	private Long userid;
	private List<Long> products;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public List<Long> getProducts() {
		return products;
	}
	public void setProducts(List<Long> products) {
		this.products = products;
	}
	
	
}
