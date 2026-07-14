package com.javacode.sinatrends.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	Order findByReferenceId(String refId);
	Optional<Order> findByUserIdAndReferenceId(Long userId, String refId);
	List<Order> findAllByUserId(Long userId);
}
