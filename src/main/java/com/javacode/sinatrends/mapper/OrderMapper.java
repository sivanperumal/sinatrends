package com.javacode.sinatrends.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.javacode.sinatrends.dto.OrderItemDto;
import com.javacode.sinatrends.dto.OrderResponseDto;
import com.javacode.sinatrends.entity.Order;

@Component
public class OrderMapper {
	public OrderResponseDto toDto(Order order) {
		OrderResponseDto responseDto = new OrderResponseDto();
		
		responseDto.setReferenceId(order.getReferenceId());
		responseDto.setUserId(order.getUser().getId());
		responseDto.setCreateAt(order.getCreateAt());
		responseDto.setUpdateAt(order.getUpdateAt());
		responseDto.setPaymentDate(order.getPaymentDate());
		responseDto.setPaymentStatus(order.getPaymentStatus());
		responseDto.setPaymentMethod(order.getPaymentMethod());
		responseDto.setRazorpayOrderId(order.getRazorpayOrderId());
		responseDto.setRazorpayPaymentId(order.getRazorpayPaymentId());
		responseDto.setShipingAmount(order.getShipingAmount());
		
		responseDto.setShippmentName(order.getShippmentName());
		responseDto.setShippmentAddress(order.getShippmentAddress());
		responseDto.setShippmentCity(order.getShippmentCity());
		responseDto.setShippmentState(order.getShippmentState());
		responseDto.setShippmentPin(order.getShippmentPin());
		responseDto.setShippmentMobile(order.getShippmentMobile());
		
		responseDto.setStatus(order.getStatus());
		responseDto.setTotalItemsAmount(order.getTotalItemsAmount());
		responseDto.setTotalAmount(order.getTotalAmount());
		
		List<OrderItemDto> orderItems =  order.getOrderItems().stream().map(item -> {
			OrderItemDto itemDto = new OrderItemDto();
			itemDto.setImage(item.getImage());
			itemDto.setName(item.getName());
			itemDto.setPrice(item.getPrice());
			itemDto.setBaseprice(item.getBasePrice());
			itemDto.setOffer(item.getOffer());
			itemDto.setQuantity(item.getQuantity());
			itemDto.setProductId(item.getProduct().getId());
			return itemDto;
		}).collect(Collectors.toList());
		
		responseDto.setOrderItems(orderItems);
		return responseDto;
	};
}
