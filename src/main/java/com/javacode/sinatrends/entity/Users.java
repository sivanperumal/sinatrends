package com.javacode.sinatrends.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	
	@Column(nullable = false)
	@NotBlank(message="Email Field is required")
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message="Password Field is required")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="user_id")
	private List<UserAddress> address = new ArrayList<UserAddress>();
	
	@Column(name="created_date", updatable = false)
	private LocalDate createdDate;
	@Column(name="updated_date")
	private LocalDate updatedDate;
	@Column(name="created_by", updatable = false)
	private LocalTime createdBy;
	@Column(name="updated_by")
	private LocalTime updatedBy;
	
	@PrePersist
	public void prePersists() {
		this.createdDate = LocalDate.now();
		this.updatedDate = LocalDate.now();
		this.createdBy = LocalTime.now();
		this.updatedBy = LocalTime.now();
	}
	
	 @PreUpdate
	 public void preUpdate() {
		 this.updatedDate = LocalDate.now();
		 this.updatedBy = LocalTime.now();
	 }

	 public Users() {
		super();
		// TODO Auto-generated constructor stub
	 }

	 public Users(Long id, String firstname, String lastname,
			@NotBlank(message = "Email Field is required") String email,
			@NotBlank(message = "Password Field is required") String password, List<UserAddress> address,
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

	 public List<UserAddress> getAddress() {
		 return address;
	 }

	 public void setAddress(List<UserAddress> address) {
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
