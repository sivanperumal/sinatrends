package com.javacode.sinatrends.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserAddressUpdated {
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String phoneno;
	private String apartmentDoorno;
	private Boolean defaultAddress;
	
	private LocalDate updatedDate;
	private LocalTime updatedBy;
	
	public UserAddressUpdated() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddressUpdated(String firstname, String lastname, String address, String city, String state,
			String pincode, String phoneno, String apartmentDoorno, Boolean defaultAddress, LocalDate updatedDate,
			LocalTime updatedBy) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneno = phoneno;
		this.apartmentDoorno = apartmentDoorno;
		this.defaultAddress = defaultAddress;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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

	public Boolean getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalTime getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(LocalTime updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
