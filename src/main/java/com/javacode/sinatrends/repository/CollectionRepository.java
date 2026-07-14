package com.javacode.sinatrends.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.sinatrends.entity.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long>{
	Optional<Collection> findBySlug(String slug);
	//List<Collection> findByCategorySlug(String slug);
	Page<Collection> findByCategorySlug(String catergory_slug, Pageable pageble);
}
