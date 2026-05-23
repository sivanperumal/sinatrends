package com.javacode.sinatrends.mapper;

import com.javacode.sinatrends.dto.ProductImageResponseDto;
import com.javacode.sinatrends.entity.ProductImage;

public class ProductImageMapper {
	
	public ProductImageResponseDto toDto(ProductImage image) {
		ProductImageResponseDto dto = new ProductImageResponseDto();
		
		dto.setId(image.getId());
		dto.setImageUrl(image.getImageUrl());
		dto.setThumbnail(image.getThumbnail());
		
		return dto;
	}
}
