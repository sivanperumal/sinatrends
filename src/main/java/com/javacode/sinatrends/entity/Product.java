package com.javacode.sinatrends.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javacode.sinatrends.enums.ProductType;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String slug;
	
	@Column(length = 1000)
	private String shortDescription;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false)
	private Double basePrice;
	
	private Double salePrice;
	
	private Integer offer;
	
	private Double rating = 0.0;

    private Integer totalReviews = 0;

    private Boolean active = true;

    private Boolean featured = false;

    private Boolean bestSeller = false;
    
    private Integer stock;
    
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    
    @ManyToOne(fetch= FetchType.LAZY)
    private Category category;
    
    @ManyToMany
    @JoinTable(
    	name="product_collections",
    	joinColumns = @JoinColumn(name="product_id"),
    	inverseJoinColumns = @JoinColumn(name="collection_id")
    )
    private List<Collection> collections;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();
    
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductVariant> variants = new ArrayList<>();
    
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews = new ArrayList<>();
    
    
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt;
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;
    
    @PrePersist
    public void onCreate() {
    	this.createdAt = LocalDateTime.now();
    	this.updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    public void onUpdate() {
    	this.updatedAt = LocalDateTime.now();
    }

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Product(Long id, String name, String slug, String shortDescription, String description, Double basePrice,
//			Double salePrice, Double rating, Integer totalReviews, Boolean active, Boolean featured, Boolean bestSeller,
//			ProductType productType, Category category, List<ProductImage> images, List<ProductVariant> variants,
//			List<ProductReview> reviews, LocalDateTime createdAt,LocalDateTime updatedAt) {
	public Product(Long id, String name, String slug, String shortDescription, String description, Double basePrice,
				Double salePrice,Integer offer, Double rating, Integer totalReviews, Boolean active, Boolean featured, Boolean bestSeller,
				Integer stock, ProductType productType, Category category, List<String> images,LocalDateTime createdAt,LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.shortDescription = shortDescription;
		this.description = description;
		this.basePrice = basePrice;
		this.salePrice = salePrice;
		this.offer = offer;
		this.rating = rating;
		this.totalReviews = totalReviews;
		this.active = active;
		this.featured = featured;
		this.bestSeller = bestSeller;
		this.stock = stock;
		this.productType = productType;
		this.category = category;
		this.images = images.stream().map(url -> new ProductImage(url,this)).collect(Collectors.toList());
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	public Integer getOffer() {
		return offer;
	}

	public void setOffer(Integer offer) {
		this.offer = offer;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public Boolean getBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(Boolean bestSeller) {
		this.bestSeller = bestSeller;
	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

	public List<ProductVariant> getVariants() {
		return variants;
	}

	public void setVariants(List<ProductVariant> variants) {
		this.variants = variants;
	}

	public List<ProductReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
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
