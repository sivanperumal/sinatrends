package com.javacode.sinatrends.mapper;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.ProductImageResponseDto;
import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.dto.ProductReviewResponseDto;
import com.javacode.sinatrends.dto.ProductVariantResponseDto;
import com.javacode.sinatrends.entity.Product;

@Component
public class ProductMapper {
	
	public ProductResponseDto toDto(Product product) {
		ProductResponseDto dto = new ProductResponseDto();
		
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setSlug(product.getSlug());
		dto.setShortDescription(product.getShortDescription());
		dto.setDescription(product.getDescription());
		dto.setBasePrice(product.getBasePrice());
		dto.setSalePrice(product.getSalePrice());
		dto.setRating(product.getRating());
		dto.setTotalReviews(product.getTotalReviews());
		dto.setActive(product.getActive());
		dto.setFeatured(product.getFeatured());
		dto.setBestSeller(product.getBestSeller());
		dto.setProductType(product.getProductType());
		dto.setCategoryName(product.getCategory().getName());
		
		List<String> collectionNames = product.getCollections().stream().map(collection-> { 
			return collection.getName();
		}).collect(Collectors.toList());
		
		List<ProductImageResponseDto> imageDtos = product.getImages().stream().map(image->{
			ProductImageResponseDto imageDto = new ProductImageResponseDto();
			imageDto.setId(image.getId());
			imageDto.setImageUrl(image.getImageUrl());
			imageDto.setThumbnail(image.getThumbnail());
			return imageDto;
		}).collect(Collectors.toList());
		
		List<ProductReviewResponseDto> reviewDtos = product.getReviews().stream().map(review->{
			ProductReviewResponseDto reviewDto = new ProductReviewResponseDto();
			reviewDto.setId(review.getId());
			reviewDto.setCustomerName(review.getCustomerName());
			reviewDto.setComment(review.getComment());
			reviewDto.setRating(review.getRating());
			reviewDto.setProductId(review.getProduct().getId());
			reviewDto.setCreatedAt(review.getCreatedAt());
			reviewDto.setUpdatedAt(review.getUpdatedAt());
			return reviewDto;
		}).collect(Collectors.toList());
		
		List<ProductVariantResponseDto> variantDtos =  product.getVariants().stream().map(variant->{
			ProductVariantResponseDto variantDto = new ProductVariantResponseDto();
			variantDto.setId(variant.getId());
			variantDto.setSize(variant.getSize());
			variantDto.setColor(variant.getColor());
			variantDto.setPrice(variant.getPrice());
			variantDto.setSku(variant.getSku());
			variantDto.setStock(variant.getStock());
			variantDto.setAvailable(variant.getAvailable());
			variantDto.setCreatedAt(variant.getCreatedAt());
			variantDto.setUpdatedAt(variant.getUpdatedAt());
			return variantDto;
		}).collect(Collectors.toList());
		
		dto.setCollectionNames(collectionNames);
		dto.setReviews(reviewDtos);
		dto.setVariants(variantDtos);
		
		return dto;
	}
}
