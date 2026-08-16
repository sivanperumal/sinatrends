package com.javacode.sinatrends.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
	@Column(nullable = false)
	@NotBlank(message="Email Field is required")
	private String email;
	
	@Column(name="created_date", updatable = false)
	private LocalDate createdDate;
	@Column(name="updated_date")
	private LocalDate updatedDate;
	@Column(name="created_by", updatable = false)
	private LocalTime createdBy;
	@Column(name="updated_by")
	private LocalTime updatedBy;
	
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequest(@NotBlank(message = "Email Field is required") String email,
			LocalDate createdDate, LocalDate updatedDate, LocalTime createdBy, LocalTime updatedBy) {
		super();
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
