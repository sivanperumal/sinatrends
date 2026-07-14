package com.javacode.sinatrends.dto;

public class OrderCreatedResponse {
	private String referenceId;

	public OrderCreatedResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCreatedResponse(String referenceId) {
		super();
		this.referenceId = referenceId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	
}	
