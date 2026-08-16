package com.javacode.sinatrends.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacode.sinatrends.entity.EmailOtp;

public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long>{
	Optional<EmailOtp> findTopByEmailOrderByIdDesc(String email);
}
