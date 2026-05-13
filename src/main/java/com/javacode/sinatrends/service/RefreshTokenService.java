package com.javacode.sinatrends.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.entity.RefreshToken;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {
	@Autowired
	private RefreshTokenRepository refreshTokenRepo;
	
	
	
	public RefreshToken getRefreshToken(String token) {
		RefreshToken refreshToken = refreshTokenRepo.findByToken(token).orElseThrow(()-> new RuntimeException("Refresh Token not found"));
		return refreshToken;
	}
	public RefreshToken createRefreshToken(Users user) {
		RefreshToken token = new RefreshToken();
		token.setToken(UUID.randomUUID().toString());
		token.setUser(user);
		token.setExpiryDate(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 24 * 7));
		return refreshTokenRepo.save(token);
	}
	
	public RefreshToken verifyToken(String token) {
		RefreshToken refreshToken = refreshTokenRepo.findByToken(token).orElseThrow(()-> new RuntimeException("Refresh Token not found"));
		
		if(refreshToken.getExpiryDate().before(new Date())) {
			throw new RuntimeException("Refresh token is expired");
		}
		return refreshToken;
	}
	
}
