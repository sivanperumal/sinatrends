package com.javacode.sinatrends.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class RefreshToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String token;
	private Date expiryDate;
	
	@OneToOne
	private Users user;

	public RefreshToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefreshToken(Long id, String token, Date expiryDate, Users user) {
		super();
		this.id = id;
		this.token = token;
		this.expiryDate = expiryDate;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
