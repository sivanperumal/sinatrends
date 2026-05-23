package com.javacode.sinatrends.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class ProductReviewResponseDto {
	private Long id;
	private String customerName;
	
	private String comment;
	
	private Double rating;
	
	private Long productId;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ProductReviewResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductReviewResponseDto(Long id, String customerName, String comment, Double rating, Long productId) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.comment = comment;
		this.rating = rating;
		this.productId = productId;
	}
	
	
}
