package com.javacode.sinatrends.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.UserAddressDto;
import com.javacode.sinatrends.dto.UserResponseDto;
import com.javacode.sinatrends.entity.UserAddress;
import com.javacode.sinatrends.entity.Users;

@Component
public class UserMapper {
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	public Users toEntity(UserResponseDto Dto) {
		Users user = new Users();
		user.setFirstname(Dto.getFirstname());
		user.setLastname(Dto.getLastname());
		user.setEmail(Dto.getEmail());
		user.setPassword(Dto.getPassword());
//		List<UserAddress> userAddress = Dto.getAddress().stream().map(addressDto -> {
//			UserAddress addressRes = userAddressMapper.toAddressEntity(addressDto);
//			return addressRes;
//		}).collect(Collectors.toList());
		//user.setAddress(userAddress);
		user.setCreatedDate(Dto.getCreatedDate());
		user.setUpdatedDate(Dto.getUpdatedDate());
		user.setCreatedBy(Dto.getCreatedBy());
		user.setUpdatedBy(Dto.getCreatedBy());
		return user;
	}
	
	public UserResponseDto toResponseDto(Users user) {
		UserResponseDto Dto = new UserResponseDto();
		Dto.setId(user.getId());
		Dto.setFirstname(user.getFirstname());
		Dto.setLastname(user.getLastname());
		Dto.setEmail(user.getEmail());
		Dto.setPassword(user.getPassword());
		
		List<UserAddressDto> userAddressDto = user.getAddress().stream().map(address->{
			UserAddressDto dtoAddress = userAddressMapper.toAddressDto(address);
			return dtoAddress;
		}).collect(Collectors.toList());
		Dto.setAddress(userAddressDto);
	    Dto.setCreatedDate(user.getCreatedDate());
	    Dto.setCreatedBy(user.getCreatedBy());
	    Dto.setUpdatedDate(user.getUpdatedDate());
	    Dto.setUpdatedBy(user.getUpdatedBy());
		return Dto;
	}
}
