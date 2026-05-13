package com.javacode.sinatrends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.UserResponseDto;
import com.javacode.sinatrends.dto.UserUpdated;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.mapper.UserMapper;
import com.javacode.sinatrends.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping
	public UserResponseDto createUser(@RequestBody UserResponseDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		UserResponseDto responseDto = userService.createUser(userDto);
		return responseDto;
		
	}
	
	@PatchMapping("/{user_id}")
	public ResponseEntity<?> updateUserById(@PathVariable Long user_id, @RequestBody UserUpdated updatedDto) {
		Users user = userService.updateUser(user_id, updatedDto);
		return ResponseEntity.ok().body(userMapper.toResponseDto(user));
	}
	
	@GetMapping
	public List<UserResponseDto> getAllUsers() {
			return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		UserResponseDto userDto = userService.getUserById(id);
		return ResponseEntity.ok().body(userDto);
	}
	
	
	
}

