package com.javacode.sinatrends.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.UserAddressDto;
import com.javacode.sinatrends.dto.UserResponseDto;
import com.javacode.sinatrends.dto.UserUpdated;
import com.javacode.sinatrends.entity.UserAddress;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.mapper.UserAddressMapper;
import com.javacode.sinatrends.mapper.UserMapper;
import com.javacode.sinatrends.repository.UserAddressRepository;
import com.javacode.sinatrends.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserAddressRepository userAddressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	public UserResponseDto createUser(UserResponseDto userDto) {
		Users user = userRepository.save(userMapper.toEntity(userDto));
		UserResponseDto dtoResponse = userMapper.toResponseDto(user);
		return dtoResponse;
	}
	
	public Users updateUser(Long user_id, UserUpdated user) {
		Users userData = userRepository.findById(user_id).orElseThrow(()-> new RuntimeException("user not found by this "+ user_id));
		BeanUtils.copyProperties(user, userData, getNullPropertyNames(user));
		return userRepository.save(userData);
	}
	
	public List<UserResponseDto> getAllUsers() {
		List<Users>  users = userRepository.findAll();
		List<UserResponseDto> dtos = users.stream().map(user->{
			UserResponseDto userDtos = userMapper.toResponseDto(user);
			return userDtos;
		}).collect(Collectors.toList());
		return dtos;
	}
	
	
	public UserResponseDto getUserById(Long id) {
		Users user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found by this"+id));
		return userMapper.toResponseDto(user);
	}
	
	public UserAddressDto createUserAddress(UserAddressDto addressdto) {
		Users user = userRepository.findById(addressdto.getUserId()).orElseThrow(()-> new RuntimeException("User not found by this "+addressdto.getUserId()));
		addressdto.setUsers(user);
		if(user.getAddress() != null && Boolean.TRUE.equals(addressdto.getDefaultAddress())) {
			for(UserAddress item: user.getAddress()) {
				item.setDefaultAddress(false);
				userAddressRepository.save(item);
			}
		}
		UserAddress address = userAddressRepository.save(userAddressMapper.toAddressEntity(addressdto));
		return userAddressMapper.toAddressDto(address);
	}
	
	public UserAddressDto getAddressById(Long id) {
		UserAddress address = userAddressRepository.findById(id).orElseThrow(()->new RuntimeException("User not found by this "+id));
		return userAddressMapper.toAddressDto(address);
	}
	
	public UserAddress updateUserAddressById(Long address_id, UserAddressDto addressDto) {
		
		UserAddress addressData = userAddressRepository.findById(address_id).orElseThrow(()-> new RuntimeException("Address not found by this "+address_id));
		
		if(addressDto.getDefaultAddress()) {
			for(UserAddress item: addressData.getUsers().getAddress()) {
				if(item.getDefaultAddress()) {
					item.setDefaultAddress(false);
				}
				userAddressRepository.save(item);
			}
		}
		
		addressData.setFirstname(addressDto.getFirstname());
		addressData.setLastname(addressDto.getLastname());
		addressData.setAddress(addressDto.getAddress());
		addressData.setCity(addressDto.getCity());
		addressData.setState(addressDto.getState());
		addressData.setPincode(addressDto.getPincode());
		addressData.setPhoneno(addressDto.getPhoneno());
		addressData.setApartmentDoorno(addressDto.getApartmentDoorno());
		addressData.setDefaultAddress(addressDto.getDefaultAddress());
		addressData.setUpdatedDate(addressDto.getUpdatedDate());
		addressData.setUpdatedBy(addressDto.getUpdatedBy());
		
		return userAddressRepository.save(addressData);
	}
	
	public String[] getNullPropertyNames(Object source) {

	    final BeanWrapper src = new BeanWrapperImpl(source);

	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    java.util.Set<String> emptyNames = new java.util.HashSet<>();

	    for (java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) {
	            emptyNames.add(pd.getName());
	        }
	    }

	    return emptyNames.toArray(new String[0]);
	}
	
	
}
