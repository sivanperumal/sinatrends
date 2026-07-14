package com.javacode.sinatrends.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Long>{
	Optional<Product> findBySlug(String slug);

	List<Product> findByCollectionsSlug(String slug);
	List<Product> findByCategorySlug(String slug);

	Page<Product> findAll(Specification<Product> spec, Pageable pageable);

	
}
