package com.javacode.sinatrends.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javacode.sinatrends.entity.Users;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserAddressDto {
	private Long id;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String phoneno;
	private String apartmentDoorno;
	private Boolean defaultAddress;
	
	@JsonIgnore
	private Users users;
	
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private LocalTime createdBy;
	private LocalTime updatedBy;
	

	public UserAddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddressDto(Long id, String firstname, String lastname,
			@NotBlank(message = "Address field is required") String address, String city, String state,
			@NotBlank(message = "Address field is required") String pincode, String phoneno, String apartmentDoorno,
			LocalDate createdDate, LocalDate updatedDate, LocalTime createdBy, LocalTime updatedBy, Boolean defaultAddress) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneno = phoneno;
		this.apartmentDoorno = apartmentDoorno;
		this.defaultAddress = defaultAddress;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getApartmentDoorno() {
		return apartmentDoorno;
	}

	public void setApartmentDoorno(String apartmentDoorno) {
		this.apartmentDoorno = apartmentDoorno;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalTime getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(LocalTime createdBy) {
		this.createdBy = createdBy;
	}

	public LocalTime getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(LocalTime updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@NotNull(message="User id field is required")
	private Long userId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Boolean getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(Boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	
}
