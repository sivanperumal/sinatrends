package com.javacode.sinatrends.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product_images")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imageUrl;
	
	private Boolean thumbnail=false;
	
	private Integer sortOrder = 0;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImage(Long id, String imageUrl, Boolean thumbnail, Integer sortOrder, Product product) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.thumbnail = thumbnail;
		this.sortOrder = sortOrder;
		this.product = product;
	}

	public ProductImage(String url, Product product) {
		// TODO Auto-generated constructor stub
		super();
		this.imageUrl = url;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Boolean thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
