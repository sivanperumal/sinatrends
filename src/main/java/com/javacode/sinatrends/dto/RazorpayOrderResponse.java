package com.javacode.sinatrends.dto;

public class RazorpayOrderResponse {
	private String orderId;
	private Double amount;
	private String currency;
	private String key;
	
	public RazorpayOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RazorpayOrderResponse(String orderId, Double amount, String currency, String key) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.currency = currency;
		this.key = key;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
