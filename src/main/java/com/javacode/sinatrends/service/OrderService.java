package com.javacode.sinatrends.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.CreateOrderRequest;
import com.javacode.sinatrends.dto.OrderCreatedResponse;
import com.javacode.sinatrends.dto.OrderItemDto;
import com.javacode.sinatrends.dto.OrderResponseDto;
import com.javacode.sinatrends.entity.Order;
import com.javacode.sinatrends.entity.OrderItem;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.mapper.OrderMapper;
import com.javacode.sinatrends.repository.OrderRepository;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.UserRepository;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;

@Service
public class OrderService {
    @Autowired
	private UserRepository userRepo;
    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private OrderRepository orderRepo;
    
    @Autowired
	private RazorpayClient razorpayClient;
    
    @Autowired
    private OrderMapper orderMapper;
    
	public OrderCreatedResponse createOrder (CreateOrderRequest orderRequest) throws Exception{
		// TODO Auto-generated method stub
		Order order = new Order();
		
		Users user = userRepo.findById(orderRequest.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
		if(user != null) {
			order.setUser(user);
		}
		
		Payment payment = razorpayClient.payments.fetch(orderRequest.getRazorpayPaymentId());
		order.setPaymentMethod(payment.get("method"));
		
		Double totalItemsAmount = 0.0;
		Double shipingAmount = 0.0;
		
		for(OrderItemDto item: orderRequest.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setName(item.getName());
			orderItem.setPrice(item.getPrice());
			orderItem.setBasePrice(item.getBaseprice());
			orderItem.setOffer(item.getOffer());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setImage(item.getImage());
			Product product = productRepo.findById(item.getProductId()).orElseThrow(()-> new RuntimeException("Product not found"));
			product.setStock(product.getStock() - item.getQuantity());
			productRepo.save(product);
			orderItem.setProduct(product);
			order.getOrderItems().add(orderItem);
			totalItemsAmount += item.getPrice()*item.getQuantity();
		}
		if(totalItemsAmount <= 3000) {
			shipingAmount += totalItemsAmount * 5/100;
		}
		order.setShippmentName(orderRequest.getShippmentName());
		order.setShippmentAddress(orderRequest.getShippmentAddress());
		order.setShippmentCity(orderRequest.getShippmentCity());
		order.setShippmentState(orderRequest.getShippmentState());
		order.setShippmentPin(orderRequest.getShippmentPin());
		order.setShippmentMobile(orderRequest.getShippmentMobile());
		order.setTotalItemsAmount(totalItemsAmount);
		order.setShipingAmount(shipingAmount);
		order.setTotalAmount(totalItemsAmount+shipingAmount);
		order.setStatus("CONFIRMED");
		order.setPaymentStatus("SUCCESS");
		order.setRazorpayOrderId(orderRequest.getRazorpayOrderId());
		order.setRazorpayPaymentId(orderRequest.getRazorpayPaymentId());
		order.setPaymentDate(LocalDateTime.now());
		order.setCreateAt(LocalDateTime.now());
		order.setUpdateAt(LocalDateTime.now());
		String refId = UUID.randomUUID().toString();
		order.setReferenceId(refId);
		orderRepo.save(order);
		return new OrderCreatedResponse(refId);
	}

	public List<OrderResponseDto> getOrdersByUser(Long userId) {
		// TODO Auto-generated method stub
		 List<Order> orders = orderRepo.findAllByUserId(userId);
		 
		 List<OrderResponseDto> orderDtoList = orders.stream().map(order -> {
			 OrderResponseDto orderDto = orderMapper.toDto(order);
			 return orderDto;
		 }).collect(Collectors.toList());
		 
		 return orderDtoList;
	}

	public OrderResponseDto getOrderByReference(String referenceId, Long userId) {
		// TODO Auto-generated method stub
		//Order order = orderRepo.findByReferenceId(referenceId);
		Order order = orderRepo.findByUserIdAndReferenceId(userId, referenceId).orElseThrow(()-> new RuntimeException("Order Not found"));
		OrderResponseDto orderDto = orderMapper.toDto(order);
		return orderDto;
	}
	
}
