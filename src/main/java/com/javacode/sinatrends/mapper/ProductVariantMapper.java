package com.javacode.sinatrends.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.CreateProductVariantDto;
import com.javacode.sinatrends.dto.ProductVariantResponseDto;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.ProductVariant;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.ProductVariantRepoistory;

@Component
public class ProductVariantMapper {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductVariantRepoistory productVariantRepo;
	
	public ProductVariant toEntity(CreateProductVariantDto dto) {
		ProductVariant entity = new ProductVariant();
		Boolean exists = productVariantRepo.existsBySizeAndColorAndProductId(dto.getSize(), dto.getColor(),dto.getProductId());
		if(exists) {
			throw new RuntimeException("Product variant already mapped same size or color in product");
		}
		
		Product product = productRepo.findById(dto.getProductId()).orElseThrow(()-> new RuntimeException("Product not found"));
		entity.setSize(dto.getSize());
		entity.setColor(dto.getColor());
		entity.setPrice(dto.getPrice());
		entity.setSku(dto.getSku());
		entity.setStock(dto.getStock());
		entity.setAvailable(dto.getAvailable());
		entity.setProduct(product);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		return entity;
	}
	
	public ProductVariantResponseDto toDto(ProductVariant variant) {
		ProductVariantResponseDto dto = new ProductVariantResponseDto();
		
		dto.setId(variant.getId());
		dto.setSize(variant.getSize());
		dto.setColor(variant.getColor());
		dto.setPrice(variant.getPrice());
		dto.setSku(variant.getSku());
		dto.setStock(variant.getStock());
		dto.setAvailable(variant.getAvailable());
		dto.setCreatedAt(variant.getCreatedAt());
		dto.setUpdatedAt(variant.getUpdatedAt());
		
		Product product = productRepo.findById(variant.getProduct().getId()).orElseThrow(()-> new RuntimeException("Product not found"));
		if(product.getId() != null) {
			dto.setProductId(product.getId());
		}
		
		return dto;
		
	}
}
