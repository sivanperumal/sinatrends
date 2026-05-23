package com.javacode.sinatrends.dto;

import java.util.List;

import com.javacode.sinatrends.enums.ProductType;



public class ProductResponseDto {
private Long id;
	
	private String name;
	private String slug;
	private String shortDescription;
	private String description;
	private Double basePrice;
	private Double salePrice;
	private Double rating;
	private Integer totalReviews;
	private Boolean active;
	private Boolean featured;
	private Boolean bestSeller;
    private ProductType productType;
    private String categoryName;
    private List<String> collectionNames;
    private List<ProductImageResponseDto> images;
    private List<ProductReviewResponseDto> reviews;
    private List<ProductVariantResponseDto> variants;
    
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
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getCollectionNames() {
		return collectionNames;
	}
	public void setCollectionNames(List<String> collectionNames) {
		this.collectionNames = collectionNames;
	}
	public List<ProductImageResponseDto> getImages() {
		return images;
	}
	public void setImages(List<ProductImageResponseDto> images) {
		this.images = images;
	}
	public List<ProductReviewResponseDto> getReviews() {
		return reviews;
	}
	public void setReviews(List<ProductReviewResponseDto> reviews) {
		this.reviews = reviews;
	}
	public List<ProductVariantResponseDto> getVariants() {
		return variants;
	}
	public void setVariants(List<ProductVariantResponseDto> variants) {
		this.variants = variants;
	}
    
    
    
}
