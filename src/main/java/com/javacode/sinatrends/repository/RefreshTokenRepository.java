package com.javacode.sinatrends.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	 Optional<RefreshToken> findByToken(String token);
}
