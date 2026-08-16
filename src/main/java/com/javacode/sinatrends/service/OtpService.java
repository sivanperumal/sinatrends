package com.javacode.sinatrends.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.entity.EmailOtp;
import com.javacode.sinatrends.repository.EmailOtpRepository;
import com.javacode.sinatrends.utils.OtpUtils;

@Service
public class OtpService {
	@Autowired
	private EmailOtpRepository otpRepo;
	
	@Autowired
	private EmailService emailService;
	
	public void generateOtp(String email) {
		String otp = OtpUtils.generateOtp();
		
		EmailOtp entity = new EmailOtp();
		entity.setEmail(email);
		entity.setOtp(otp);
		entity.setUsed(false);
		entity.setVerified(false);
		entity.setExpiryTime(LocalDateTime.now().plusMinutes(10));
		
		otpRepo.save(entity);
		emailService.sendOtp(email, otp);
	}
}
