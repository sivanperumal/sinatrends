package com.javacode.sinatrends.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	@Column(nullable = false)
	@NotBlank(message="Address field is required")
	private String address;
	private String city;
	private String state;
	@Column(nullable = false)
	@NotBlank(message="Address field is required")
	private String pincode;
	private String phoneno;
	private String apartmentDoorno;
	
	private Boolean defaultAddress;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
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
		this.createdBy 	= LocalTime.now();
		this.updatedBy	= LocalTime.now();	
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedDate = LocalDate.now();
		this.updatedBy =LocalTime.now();
	}

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(Long id, String firstname, String lastname,
			@NotBlank(message = "Address field is required") String address, String city, String state,
			@NotBlank(message = "Address field is required") String pincode, String phoneno, String apartmentDoorno,Boolean defaultAddress,
			LocalDate createdDate, LocalDate updatedDate, LocalTime createdBy, LocalTime updatedBy) {
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

	public Boolean getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	
	
}
