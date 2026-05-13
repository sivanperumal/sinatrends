package com.javacode.sinatrends.dto;

import jakarta.validation.constraints.NotBlank;

public class UserUpdated {
	private String firstname;
	private String lastname;
	
	
	public UserUpdated() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserUpdated(@NotBlank(message = "Firstname field is required") String firstname,
			@NotBlank(message = "Lastname field is required") String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
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
	
	
	
	
	
}
