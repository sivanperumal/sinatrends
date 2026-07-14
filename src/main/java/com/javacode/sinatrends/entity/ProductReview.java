package com.javacode.sinatrends.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="product_reviews")
public class ProductReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	@Min(value = 1)
	@Max(value = 5)
	private Double rating;
	
	@Column(nullable = false)
	private Boolean isVerified = false;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	@Column(name="createdAt", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	public ProductReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductReview(Long id, String customerName, String comment, @Min(1) @Max(5) Double rating, Product product,Boolean isVerified, Users users, LocalDateTime createdAt,LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.comment = comment;
		this.rating = rating;
		this.product = product;
		this.users = users;
		this.isVerified = isVerified;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
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
	
	
}
