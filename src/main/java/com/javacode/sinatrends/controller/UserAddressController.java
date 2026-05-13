package com.javacode.sinatrends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.UserAddressDto;
import com.javacode.sinatrends.entity.UserAddress;
import com.javacode.sinatrends.mapper.UserAddressMapper;
import com.javacode.sinatrends.repository.UserAddressRepository;
import com.javacode.sinatrends.repository.UserRepository;
import com.javacode.sinatrends.service.UserService;

@RestController
@RequestMapping("/api/address")
public class UserAddressController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Autowired
	private UserAddressRepository userAddressRepo;
	
	@PostMapping
	public ResponseEntity<?> createUserAddress(@RequestBody UserAddressDto addressDto) {
		userService.createUserAddress(addressDto);
	    return ResponseEntity.ok().body("Address added suucessfully");
	}
	
	@GetMapping("/{address_id}")
	public ResponseEntity<?> getUserAddressById(@PathVariable Long address_id) {
		UserAddressDto addressDto = userService.getAddressById(address_id);
		return ResponseEntity.ok().body(addressDto);
	}
	
	@PutMapping("/{address_id}")
	public ResponseEntity<?> updateUserAddressById(@PathVariable Long address_id, @RequestBody UserAddressDto addressDto) {
		UserAddress address = userService.updateUserAddressById(address_id,addressDto);
		return ResponseEntity.ok().body(userAddressMapper.toAddressDto(address));
	}
	
	@DeleteMapping("/{address_id}")
	public ResponseEntity<?> deleteUserAddressById(@PathVariable Long address_id) {
		UserAddress addressData = userAddressRepo.findById(address_id).orElseThrow(()-> new RuntimeException("Address not found by this "+address_id));
		userAddressRepo.delete(addressData);
		return ResponseEntity.ok().body("Address Deleted successfully");
	}
	
	
}
