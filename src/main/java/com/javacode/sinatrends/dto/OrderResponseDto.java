package com.javacode.sinatrends.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javacode.sinatrends.entity.OrderItem;



public class OrderResponseDto {
	private String referenceId;
	private Long userId;
	private Double totalItemsAmount;
	private Double shipingAmount;
	private Double totalAmount;
	private String status;
	private String shippmentName;
	private String shippmentAddress;
	private String shippmentCity;
	private String shippmentState;
	private String shippmentPin;
	private String shippmentMobile;
	private String paymentStatus;
	private String paymentMethod;
	private String razorpayOrderId;
	private String razorpayPaymentId;
	private LocalDateTime paymentDate;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	private List<OrderItemDto> orderItems = new ArrayList<OrderItemDto>();

	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponseDto(String referenceId, Long userId, Double totalItemsAmount, Double shipingAmount,
			Double totalAmount, String status, String shippmentName,String shippmentAddress,String shippmentCity,
			String shippmentState,String shippmentPin,String shippmentMobile, 
			String paymentStatus, String paymentMethod, String razorpayOrderId, String razorpayPaymentId, LocalDateTime paymentDate, LocalDateTime createAt,
			LocalDateTime updateAt, List<OrderItemDto> orderItems) {
		super();
		this.referenceId = referenceId;
		this.userId = userId;
		this.totalItemsAmount = totalItemsAmount;
		this.shipingAmount = shipingAmount;
		this.totalAmount = totalAmount;
		this.status = status;
		this.shippmentName = shippmentName;
		this.shippmentAddress = shippmentAddress;
		this.shippmentCity = shippmentCity;
		this.shippmentState = shippmentState;
		this.shippmentPin = shippmentPin;
		this.shippmentMobile = shippmentMobile;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.razorpayOrderId = razorpayOrderId;
		this.razorpayPaymentId = razorpayPaymentId;
		this.paymentDate = paymentDate;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.orderItems = orderItems;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getTotalItemsAmount() {
		return totalItemsAmount;
	}

	public void setTotalItemsAmount(Double totalItemsAmount) {
		this.totalItemsAmount = totalItemsAmount;
	}

	public Double getShipingAmount() {
		return shipingAmount;
	}

	public void setShipingAmount(Double shipingAmount) {
		this.shipingAmount = shipingAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}
}
