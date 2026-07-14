package com.javacode.sinatrends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long>{
	List<Wishlist> findByUserId(Long userId);
	
	Boolean existsByUserIdAndProductId(Long userId, Long productId);
	
  //void deleteByUserIdAndProductId(Long userId, Long productId);
	void deleteByUserIdAndProductId(
            Long userId,
            Long productId
    );
}
