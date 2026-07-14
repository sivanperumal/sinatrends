package com.javacode.sinatrends.dto;

public class PaymentRequest {

	private Double amount;

	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentRequest(Double amount) {
		super();
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
