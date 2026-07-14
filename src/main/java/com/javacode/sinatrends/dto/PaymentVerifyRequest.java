package com.javacode.sinatrends.dto;

public class PaymentVerifyRequest {
	private String razorpayPaymentId;
	private String razorpayOrderId;
	private String razorpaySignature;
	
	private CreateOrderRequest orderRequest;

	public PaymentVerifyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentVerifyRequest(String razorpayPaymentId, String razorpayOrderId, String razorpaySignature,
			CreateOrderRequest orderRequest) {
		super();
		this.razorpayPaymentId = razorpayPaymentId;
		this.razorpayOrderId = razorpayOrderId;
		this.razorpaySignature = razorpaySignature;
		this.orderRequest = orderRequest;
	}

	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}

	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public String getRazorpaySignature() {
		return razorpaySignature;
	}

	public void setRazorpaySignature(String razorpaySignature) {
		this.razorpaySignature = razorpaySignature;
	}

	public CreateOrderRequest getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(CreateOrderRequest orderRequest) {
		this.orderRequest = orderRequest;
	}
	
	
}
