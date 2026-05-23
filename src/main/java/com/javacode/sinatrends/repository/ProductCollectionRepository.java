package com.javacode.sinatrends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.ProductCollection;

public interface ProductCollectionRepository extends JpaRepository<ProductCollection, Long>{
		Boolean existsByProductIdAndCollectionId(Long productId, Long collectionId);
}
