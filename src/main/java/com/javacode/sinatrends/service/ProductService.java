package com.javacode.sinatrends.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CreateProductReviewDto;
import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.ProductReview;
import com.javacode.sinatrends.mapper.ProductMapper;
import com.javacode.sinatrends.mapper.ProductReviewMapper;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.ProductReviewRepository;
import com.javacode.sinatrends.spec.ProductSpecification;

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
	
	public ProductResponseDto getProductDetailsBySlug(String slug) {
		// TODO Auto-generated method stub
		Product responseProduct = productRepository.findBySlug(slug).orElseThrow(()-> new RuntimeException("Product not found"));
		ProductResponseDto productDtoResponse = productMapper.toDto(responseProduct);
		return productDtoResponse;
	}

	public List<ProductResponseDto> searchProducts(String keyword,Integer availability,Double min, Double max, int page, int size) {
		// TODO Auto-generated method stub
		Specification<Product> spec =  Specification.where(ProductSpecification.hasNameOrDescriptionLike(keyword))
													.and(ProductSpecification.hasAvailability(availability))
													.and(ProductSpecification.priceBetween(min, max));
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products =productRepository.findAll(spec,pageable);
		List<ProductResponseDto> productDtos = products.getContent().stream().map(product-> {
			ProductResponseDto productDto =  productMapper.toDto(product);
			return productDto;
		}).collect(Collectors.toList());
		System.out.println(products.getContent());
		return productDtos;
	}

	
}
