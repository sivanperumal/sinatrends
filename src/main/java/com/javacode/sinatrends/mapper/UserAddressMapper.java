package com.javacode.sinatrends.mapper;

import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.UserAddressDto;
import com.javacode.sinatrends.entity.UserAddress;

@Component
public class UserAddressMapper {
	
	public UserAddress toAddressEntity(UserAddressDto addressDto) {
		UserAddress address = new UserAddress();
		address.setId(address.getId());
		address.setFirstname(addressDto.getFirstname());
		address.setLastname(addressDto.getLastname());
		address.setAddress(addressDto.getAddress());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setPincode(addressDto.getPincode());
		address.setPhoneno(addressDto.getPhoneno());
		address.setApartmentDoorno(addressDto.getApartmentDoorno());
		address.setDefaultAddress(addressDto.getDefaultAddress());
		address.setCreatedDate(addressDto.getCreatedDate());
		address.setUpdatedDate(addressDto.getUpdatedDate());
		address.setCreatedBy(addressDto.getCreatedBy());
		address.setUpdatedBy(addressDto.getUpdatedBy());
		address.setUsers(addressDto.getUsers());
		
		return address;
	}
	
	public UserAddressDto toAddressDto(UserAddress address) {
		UserAddressDto addressDto = new UserAddressDto();
		addressDto.setId(address.getId());
		addressDto.setFirstname(address.getFirstname());
		addressDto.setLastname(address.getLastname());
		addressDto.setAddress(address.getAddress());
		addressDto.setCity(address.getCity());
		addressDto.setState(address.getState());
		addressDto.setPincode(address.getPincode());
		addressDto.setPhoneno(address.getPhoneno());
		addressDto.setApartmentDoorno(address.getApartmentDoorno());
		addressDto.setDefaultAddress(address.getDefaultAddress());
		addressDto.setCreatedDate(address.getCreatedDate());
		addressDto.setUpdatedDate(address.getUpdatedDate());
		addressDto.setCreatedBy(address.getCreatedBy());
		addressDto.setUpdatedBy(address.getUpdatedBy());
		addressDto.setUserId(address.getUsers().getId());
		addressDto.setUsers(address.getUsers());
		
		return addressDto;
	}
	
	
}
