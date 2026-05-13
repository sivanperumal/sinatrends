package com.javacode.sinatrends.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.UserResponseDto;
import com.javacode.sinatrends.entity.RefreshToken;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.mapper.UserMapper;
import com.javacode.sinatrends.repository.RefreshTokenRepository;
import com.javacode.sinatrends.repository.UserRepository;
import com.javacode.sinatrends.security.JwtUtils;
import com.javacode.sinatrends.service.RefreshTokenService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Map<String, Object> request) {
		//Users user = userMapper.toEntity(userDto);
		
		String email = (String)request.get("email");
		String password	= (String)request.get("password");
		
		int expiresInMins = request.get("expiresInMins") != null ?  (int)request.get("expiresInMins") : 60 ;
	    
		try {
			Users userItems = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found by this "+email));
			Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			UserDetails userDetails = (UserDetails)authentication.getPrincipal();
			String token = jwtUtils.generateToken(userDetails,expiresInMins);
			
			Map<String, Object> responseMap = new HashMap<String, Object>();
			
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userItems);
			
			responseMap.put("user", userMapper.toResponseDto(userItems));
			responseMap.put("accessToken", token);
			responseMap.put("refreshToken", refreshToken.getToken());
			return ResponseEntity.ok().body(responseMap);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(401).body("Invalid username or password");
		}
		
	}
	
	@GetMapping("/me")
	public ResponseEntity<?> getCurrentUser(Authentication authentication) {
		
		if(authentication == null) {
			return ResponseEntity.status(401).body("Unauthorized");

		}
		String email = authentication.getName();
		
		Users user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found by this "+email));
		
		return ResponseEntity.ok().body(userMapper.toResponseDto(user));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refresh(@RequestBody Map<String, Object> request) {
		String refreshTokenString = (String) request.get("refreshToken");
		int expiresInMins = request.get("expiresInMins") != null ? (int)request.get("expiresInMins") : 60;
		
		RefreshToken refreshToken = refreshTokenService.verifyToken(refreshTokenString);
		Users user = refreshToken.getUser();
		
//		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
//		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
	            user.getEmail(), user.getPassword(), new ArrayList<>()
	    );
		
		String token = jwtUtils.generateToken(userDetails, expiresInMins);
		
		return ResponseEntity.ok().body(
				Map.of(
						"accessToken",token,
						"refreshToken", refreshTokenString)
				);
				
	}
	
	@DeleteMapping("/refresh/{refresh_token}")
	public ResponseEntity<String> deleteRefresh(@PathVariable String refresh_token) {
		RefreshToken refreshToken = refreshTokenService.getRefreshToken(refresh_token);
		RefreshToken refreshTokendData = refreshTokenRepository.findByToken(refresh_token)
									.orElseThrow(() -> new RuntimeException("Refresh Token not found by this Token "+ refresh_token));
		refreshTokenRepository.delete(refreshTokendData);
		return ResponseEntity.ok().body("Refresh Token deleted successfully");
	}
	
//	private Map<String, Object> convertToMap(Object obj) {
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    return objectMapper.convertValue(obj, Map.class);
//	}
}
