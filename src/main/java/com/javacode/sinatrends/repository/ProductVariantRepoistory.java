package com.javacode.sinatrends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.ProductVariant;

public interface ProductVariantRepoistory extends JpaRepository<ProductVariant, Long>{
		Boolean existsBySizeAndColorAndProductId(String size,String color,Long product_id);
}
