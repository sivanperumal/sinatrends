package com.javacode.sinatrends.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private static final String SECRET_KEY_STRING = "g8ZZdJXVx4oGHtK2sXJ7TJF66fBr5wE5";
	private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());
	
	public String generateToken(UserDetails userDetails, int expiresInMins) {
		return Jwts.builder()
			.subject(userDetails.getUsername())
			.issuedAt(new Date())
			.expiration(new Date(System.currentTimeMillis() + 1000 * expiresInMins *60))
			.signWith(SECRET_KEY, SIG.HS256)
			.compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		 return extractUsername(token).equals(userDetails.getUsername());
	}
	
	public String extractUsername(String token) {
		return Jwts.parser()
					.verifyWith(SECRET_KEY)
					.build()
					.parseSignedClaims(token)
					.getPayload()
					.getSubject();
				   
	}
	
	public boolean isTokenExpired(String token) {
	    Date exp = Jwts.parser()
	        .verifyWith(SECRET_KEY)
	        .build()
	        .parseSignedClaims(token)
	        .getPayload()
	        .getExpiration();

	    return exp.before(new Date());
	}
}
