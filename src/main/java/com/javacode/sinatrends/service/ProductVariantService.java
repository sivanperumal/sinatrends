package com.javacode.sinatrends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CreateProductVariantDto;
import com.javacode.sinatrends.dto.ProductVariantResponseDto;
import com.javacode.sinatrends.entity.ProductVariant;
import com.javacode.sinatrends.mapper.ProductVariantMapper;
import com.javacode.sinatrends.repository.ProductVariantRepoistory;

@Service
public class ProductVariantService {
	
	@Autowired
	private ProductVariantMapper productVariantMapper;
	@Autowired
	private ProductVariantRepoistory productVariantRepo;
	
	public ProductVariantResponseDto createProductVariant(CreateProductVariantDto variantDto) {
		// TODO Auto-generated method stub
		ProductVariant variant = productVariantMapper.toEntity(variantDto);
		ProductVariantResponseDto dto = productVariantMapper.toDto(productVariantRepo.save(variant));
		return dto;
	}

	public String deleteProductVariant(Long variantId) {
		// TODO Auto-generated method stub
		ProductVariant variant = productVariantRepo.findById(variantId).orElseThrow(()-> new RuntimeException("Product variant was not found"));
		productVariantRepo.delete(variant);
		return "Product variant deleted successfully";
	}
	
}
