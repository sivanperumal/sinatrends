package com.javacode.sinatrends.mapper;

import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.CollectionResponseDto;
import com.javacode.sinatrends.entity.Collection;

@Component
public class CollectionMapper {
	public CollectionResponseDto toDto(Collection collection) {
		CollectionResponseDto dto = new CollectionResponseDto();
		dto.setId(collection.getId());
		dto.setName(collection.getName());
		dto.setSlug(collection.getSlug());
		dto.setThumbnail_image(collection.getThumbnailImage());
		dto.setBanner_image(collection.getBannerImage());
		dto.setCreated_at(collection.getCreatedAt());
		dto.setUpdated_at(collection.getUpdatedAt());
		
		return dto;
	}
}
