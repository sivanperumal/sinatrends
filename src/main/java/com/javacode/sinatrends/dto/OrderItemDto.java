package com.javacode.sinatrends.dto;

public class OrderItemDto {
	private String name;
	private Double price;
	private Double baseprice;
	private Double offer;
	private Integer quantity;
	private String image;
	private Long productId;
	
	public OrderItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemDto(String name, Double price,Double basePrice,Double offer, Integer quantity, String image, Long productId) {
		super();
		this.name = name;
		this.price = price;
		this.baseprice = basePrice;
		this.offer = offer;
		this.quantity = quantity;
		this.image = image;
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}
	
	
	public Double getOffer() {
		return offer;
	}

	public void setOffer(Double offer) {
		this.offer = offer;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
