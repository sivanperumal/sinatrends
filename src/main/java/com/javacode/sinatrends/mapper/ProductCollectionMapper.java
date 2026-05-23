package com.javacode.sinatrends.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.CreateProductCollectionDto;
import com.javacode.sinatrends.dto.ProductCollectionResponseDto;
import com.javacode.sinatrends.entity.Collection;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.ProductCollection;
import com.javacode.sinatrends.repository.CollectionRepository;
import com.javacode.sinatrends.repository.ProductRepository;

@Component
public class ProductCollectionMapper {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CollectionRepository collectionRepo;
	
	public ProductCollection toEntity(CreateProductCollectionDto dto) {
		Product product = productRepository.findById(dto.getProduct_id()).orElseThrow(()-> new RuntimeException("Product not found"));
		Collection collection = collectionRepo.findById(dto.getCollection_id()).orElseThrow(()->new RuntimeException("Collection not found"));
		
		ProductCollection entity = new ProductCollection();
		
		entity.setProduct(product);
		entity.setCollection(collection);
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		return entity;
	}
	
	public ProductCollectionResponseDto toDto(ProductCollection collectionItem) {
		
		Product product = productRepository.findById(collectionItem.getProduct().getId()).orElseThrow(()->new RuntimeException("Product not found"));
		Collection collection = collectionRepo.findById(collectionItem.getCollection().getId()).orElseThrow(()->new RuntimeException("Collection not found"));
		
		ProductCollectionResponseDto productCollectionResponse = new ProductCollectionResponseDto();
		
		productCollectionResponse.setId(collectionItem.getId());
		if(product.getId() != null) {
			productCollectionResponse.setProductId(product.getId());
			productCollectionResponse.setProductName(product.getName());
		}
		if(collection.getId() != null) {
			productCollectionResponse.setCollectionId(collection.getId());
			productCollectionResponse.setCollectionName(collection.getName());
		}
		
		return productCollectionResponse;
	}
}
