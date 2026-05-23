package com.javacode.sinatrends.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CreateProductReviewDto;
import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.ProductReview;
import com.javacode.sinatrends.mapper.ProductMapper;
import com.javacode.sinatrends.mapper.ProductReviewMapper;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.ProductReviewRepository;

@Service
public class ProductService {
	@Autowired
	private ProductReviewMapper reviewMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductReviewRepository productReviewRepo;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductReview createProductReview(CreateProductReviewDto reviewDto) {
		// TODO Auto-generated method stub
		ProductReview review = reviewMapper.toReviewEntity(reviewDto);
		ProductReview reviewResponse =  productReviewRepo.save(review);
		return reviewResponse;
	}
	
	public List<ProductResponseDto> getAllProducts() {
		List<Product> products =  productRepository.findAll();
		
		List<ProductResponseDto> productResponseDtos = products.stream().map(product-> {
			ProductResponseDto productDto =  productMapper.toDto(product);
			return productDto;
		}).collect(Collectors.toList());
		
		return productResponseDtos;
	}

	public List<ProductResponseDto> getProductsByCollectionBySlug(String slug) {
		// TODO Auto-generated method stub
		List<Product> products =  productRepository.findByCollectionsSlug(slug);
		
		List<ProductResponseDto> productDtos = products.stream().map(product-> {
			ProductResponseDto productDto =  productMapper.toDto(product);
			return productDto;
		}).collect(Collectors.toList());
		return productDtos;
	}

	public List<ProductResponseDto> getProductsByCategorySlug(String catergory_slug) {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findByCategorySlug(catergory_slug);
		List<ProductResponseDto> productDtos = products.stream().map(product-> {
			ProductResponseDto productDto =  productMapper.toDto(product);
			return productDto;
		}).collect(Collectors.toList());
		return productDtos;
	}
}
