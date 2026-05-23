package com.javacode.sinatrends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CreateProductCollectionDto;
import com.javacode.sinatrends.dto.ProductCollectionResponseDto;
import com.javacode.sinatrends.entity.ProductCollection;
import com.javacode.sinatrends.mapper.ProductCollectionMapper;
import com.javacode.sinatrends.repository.ProductCollectionRepository;

@Service
public class ProductCollectionService {
	
	@Autowired
	private ProductCollectionMapper productCollectionMapper;
	
	@Autowired
	private ProductCollectionRepository productCollectionRepo;
	
	public ProductCollectionResponseDto createProductCollection(CreateProductCollectionDto collectionDto) {
		Boolean exists = productCollectionRepo.existsByProductIdAndCollectionId(collectionDto.getProduct_id(), collectionDto.getCollection_id());
		if(exists) {
			throw new RuntimeException("Product already mapped to this collection");
		}
		// TODO Auto-generated method stub
		ProductCollection productCollection =  productCollectionMapper.toEntity(collectionDto);
		
		ProductCollectionResponseDto productCollectionResponse = productCollectionMapper.toDto(productCollectionRepo.save(productCollection)); 
		return productCollectionResponse;
	}
}
