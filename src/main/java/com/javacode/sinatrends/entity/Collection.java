package com.javacode.sinatrends.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="collections")
public class Collection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String slug;
	
	private String bannerImage;
	
	private String thumbnailImage;
	
	private Boolean active= true;
	@Column(name="created_at", updatable = false)
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt =LocalDateTime.now();
	}
	
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection(Long id, String name, String slug, String bannerImage, String thumbnailImage, Boolean active,LocalDateTime createdAt,LocalDateTime updatedAt, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.bannerImage = bannerImage;
		this.thumbnailImage = thumbnailImage;
		this.active = active;
		this.createdAt =createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	
	public String getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
