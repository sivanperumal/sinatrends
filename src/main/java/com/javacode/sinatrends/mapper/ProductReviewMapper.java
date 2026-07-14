package com.javacode.sinatrends.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.CreateProductReviewDto;
import com.javacode.sinatrends.dto.ProductReviewResponseDto;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.ProductReview;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.UserRepository;

@Component
public class ProductReviewMapper {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public ProductReview toReviewEntity(CreateProductReviewDto reviewDto) {
		
		Product product = productRepo.findById(reviewDto.getProductId()).orElseThrow(()-> new RuntimeException("product not found by this "+reviewDto.getProductId()));
		Users user = userRepo.findById(reviewDto.getUserId()).orElseThrow(()-> new RuntimeException("user not found"));
		ProductReview review = new ProductReview();
		
		review.setCustomerName(reviewDto.getCustomerName());
		review.setComment(reviewDto.getComment());
		review.setRating(reviewDto.getRating());
		review.setCreatedAt(LocalDateTime.now());
		review.setUpdatedAt(LocalDateTime.now());
		review.setProduct(product);
		review.setIsVerified(reviewDto.getIsVerified());
		review.setUsers(user);
		
		return review;
	}
	
	public ProductReviewResponseDto toReviewResponseDto(ProductReview review) {
		ProductReviewResponseDto reviewDto = new ProductReviewResponseDto();
		
		reviewDto.setId(review.getId());
		reviewDto.setCustomerName(review.getCustomerName());
		reviewDto.setComment(review.getComment());
		reviewDto.setRating(review.getRating());
		if(review.getProduct() != null) {
			reviewDto.setProductId(review.getProduct().getId());
		}
		if(review.getUsers() != null) {
			reviewDto.setUserId(review.getUsers().getId());
		}
		reviewDto.setIsVerified(review.getIsVerified());
		reviewDto.setCreatedAt(review.getCreatedAt());
		reviewDto.setUpdatedAt(review.getUpdatedAt());
		return reviewDto;
		
	}
	
}
