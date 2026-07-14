package com.javacode.sinatrends.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Boolean existsByUserIdAndProductId(Long userId, Long productId);

	List<Cart> findByUserId(Long id);
	
	Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);
	
}
