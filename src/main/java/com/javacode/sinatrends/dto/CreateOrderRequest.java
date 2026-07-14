package com.javacode.sinatrends.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CreateOrderRequest {
	private List<OrderItemDto> orderItems;
	private Long userId;
	private String shippmentName;
	private String shippmentAddress;
	private String shippmentCity;
	private String shippmentState;
	private String shippmentPin;
	private String shippmentMobile;
	private String razorpayOrderId;
	private String razorpayPaymentId;
	private LocalDateTime paymentDate;
	
	public CreateOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateOrderRequest(List<OrderItemDto> orderItems, Long userId, 
			String shippmentName,String shippmentAddress,String shippmentCity,String shippmentState,String shippmentPin,String shippmentMobile
			,String razorpayOrderId,String razorpayPaymentId,LocalDateTime paymentDate) {
		super();
		this.orderItems = orderItems;
		this.userId = userId;
		this.shippmentName = shippmentName;
		this.shippmentAddress = shippmentAddress;
		this.shippmentCity = shippmentCity;
		this.shippmentState = shippmentState;
		this.shippmentPin = shippmentPin;
		this.shippmentMobile = shippmentMobile;
		this.razorpayOrderId = razorpayOrderId;
		this.razorpayPaymentId = razorpayPaymentId;
		this.paymentDate = paymentDate;
	}
	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getShippmentName() {
		return shippmentName;
	}
	public void setShippmentName(String shippmentName) {
		this.shippmentName = shippmentName;
	}
	public String getShippmentAddress() {
		return shippmentAddress;
	}
	public void setShippmentAddress(String shippmentAddress) {
		this.shippmentAddress = shippmentAddress;
	}
	public String getShippmentCity() {
		return shippmentCity;
	}
	public void setShippmentCity(String shippmentCity) {
		this.shippmentCity = shippmentCity;
	}
	public String getShippmentState() {
		return shippmentState;
	}
	public void setShippmentState(String shippmentState) {
		this.shippmentState = shippmentState;
	}
	public String getShippmentPin() {
		return shippmentPin;
	}
	public void setShippmentPin(String shippmentPin) {
		this.shippmentPin = shippmentPin;
	}
	public String getShippmentMobile() {
		return shippmentMobile;
	}
	public void setShippmentMobile(String shippmentMobile) {
		this.shippmentMobile = shippmentMobile;
	}
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}
	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
