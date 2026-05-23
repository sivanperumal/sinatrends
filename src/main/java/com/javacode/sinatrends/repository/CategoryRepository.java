package com.javacode.sinatrends.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Optional<Category> findBySlug(String slug);
}
