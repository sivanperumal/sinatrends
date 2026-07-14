package com.javacode.sinatrends.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CollectionResponseDto;
import com.javacode.sinatrends.entity.Collection;
import com.javacode.sinatrends.mapper.CollectionMapper;
import com.javacode.sinatrends.repository.CollectionRepository;

@Service
public class CollectionService {
	@Autowired
	private CollectionRepository collectionRepo;
	
	@Autowired
	private CollectionMapper collectionMapper;
	
	public List<CollectionResponseDto> getCollectionByCategorySlug(int page, int size,String catergory_slug) {
		// TODO Auto-generated method stub
		Pageable pageble = PageRequest.of(page, size);
		Page<Collection> collections = collectionRepo.findByCategorySlug(catergory_slug, pageble);
		List<CollectionResponseDto> collectionDtos = collections.stream().map(collection->{
			CollectionResponseDto collectionDto = collectionMapper.toDto(collection);
			return collectionDto;
		}).collect(Collectors.toList());
		return collectionDtos;
	}
	
}
