package com.javacode.sinatrends.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.javacode.sinatrends.entity.UserAddress;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;

public class UserResponseDto {
	private Long id;
	
	private String firstname;
	private String lastname;
	
	@Column(nullable = false)
	@NotBlank(message="Email Field is required")
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message="Password Field is required")
	private String password;
	
	private List<UserAddressDto> address;
	
	@Column(name="created_date", updatable = false)
	private LocalDate createdDate;
	@Column(name="updated_date")
	private LocalDate updatedDate;
	@Column(name="created_by", updatable = false)
	private LocalTime createdBy;
	@Column(name="updated_by")
	private LocalTime updatedBy;
	
	public UserResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	 }

	 public UserResponseDto(Long id, String firstname, String lastname,
			@NotBlank(message = "Email Field is required") String email,
			@NotBlank(message = "Password Field is required") String password, List<UserAddressDto> address,
			LocalDate createdDate, LocalDate updatedDate, LocalTime createdBy, LocalTime updatedBy) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
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

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public List<UserAddressDto> getAddress() {
		 return address;
	 }

	 public void setAddress(List<UserAddressDto> address) {
		 this.address = address;
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
	 
	 
}
