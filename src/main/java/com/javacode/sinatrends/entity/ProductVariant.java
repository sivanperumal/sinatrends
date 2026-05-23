package com.javacode.sinatrends.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(
	name="product_variants",
	uniqueConstraints = {
		@UniqueConstraint(
			columnNames = {
				"size",
				"color",
				"product_id"
			}
		)
	}
)
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String size;
	private String color;
	private Integer stock;
	private Double price;
	private String sku;
	private Boolean available=true;
	@Column(name="created_at", updatable = false)
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVariant(Long id, String size, String color, Integer stock, Double price, String sku,
			Boolean available,LocalDateTime createdAt,LocalDateTime updatedAt, Product product) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.stock = stock;
		this.price = price;
		this.sku = sku;
		this.available = available;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
