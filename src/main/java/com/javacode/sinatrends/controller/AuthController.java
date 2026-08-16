package com.javacode.sinatrends.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.UserResponseDto;
import com.javacode.sinatrends.entity.EmailOtp;
import com.javacode.sinatrends.entity.RefreshToken;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.mapper.UserMapper;
import com.javacode.sinatrends.repository.EmailOtpRepository;
import com.javacode.sinatrends.repository.RefreshTokenRepository;
import com.javacode.sinatrends.repository.UserRepository;
import com.javacode.sinatrends.security.JwtUtils;
import com.javacode.sinatrends.service.OtpService;
import com.javacode.sinatrends.service.RefreshTokenService;
import com.javacode.sinatrends.service.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private EmailOtpRepository otpRepo;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepo;
	
	@PostMapping("/request-otp")
	public ResponseEntity<?> requestOtp(@RequestBody Map<String, Object> request){
		String email = (String) request.get("email");
		try {
			Optional<Users> user = userRepo.findByEmail(email);
			Map<String, Object> responseMap = new HashMap<String, Object>();
			if(user.isEmpty()) {
				UserResponseDto responseDto = userService.createUserByEmail(email);
			}
			otpService.generateOtp(email);
			responseMap.put("message", "OTP send successfully");
			//responseMap.put("requestOtp", true);
			
			return ResponseEntity.ok().body(responseMap);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put("message", e.getMessage());
			//responseMap.put("requestOtp", false);
			return ResponseEntity.status(401).body(responseMap);
		}
		
		
	}
	
	@PostMapping("/verify-otp")
	public ResponseEntity<?> verifyOtp(@RequestBody Map<String,Object> request) {
		String email = (String)request.get("email");
		String otp = (String) request.get("otp");
		int expiresInMins =  request.get("expiresInMins") != null ? (int)request.get("expiresInMins"): 120;
		try {
			
			EmailOtp emailOtp = otpRepo.findTopByEmailOrderByIdDesc(email).orElseThrow(()-> new RuntimeException("Email not found"));
			
			if(emailOtp.getUsed()) {
				return ResponseEntity.badRequest().body("OTP was already used");
			}
			if(LocalDateTime.now().isAfter(emailOtp.getExpiryTime())) {
				return ResponseEntity.badRequest().body("OTP expired");
			}
			if(!emailOtp.getOtp().equals(otp)){
				return ResponseEntity.badRequest().body("OTP is invalid");
			}
			
			emailOtp.setUsed(true);
			otpRepo.save(emailOtp);
			
			Users userItems = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found by this "+email));
			UserDetails userDetails=
		            new User(
		            		userItems.getEmail(),
		            		userItems.getPassword(),
		                    new ArrayList<>());
			String token = jwtUtils.generateToken(userDetails,expiresInMins);
			
			Map<String, Object> responseMap = new HashMap<String, Object>();
			
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userItems);
			
			responseMap.put("user", userMapper.toResponseDto(userItems));
			responseMap.put("accessToken", token);
			responseMap.put("refreshToken", refreshToken.getToken());
			return ResponseEntity.ok().body(responseMap);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(401).body(Map.of("message",e.getMessage()));
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Map<String, Object> request) {
		//Users user = userMapper.toEntity(userDto);
		
		String email = (String)request.get("email");
		String password	= (String)request.get("password");
		
		int expiresInMins = request.get("expiresInMins") != null ?  (int)request.get("expiresInMins") : 120 ;
	    
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
		if(refreshToken != null) {
			RefreshToken refreshTokendData = refreshTokenRepo.findByToken(refresh_token)
					.orElseThrow(() -> new RuntimeException("Refresh Token not found by this Token "+ refresh_token));
			refreshTokenRepo.delete(refreshTokendData);
			return ResponseEntity.ok().body("Refresh Token deleted successfully");
		}
		else {
			return ResponseEntity.badRequest().body("Invalid Refresh token");
		}
		
	}
	

}
