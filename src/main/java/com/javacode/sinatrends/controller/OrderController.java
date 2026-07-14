package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javacode.sinatrends.dto.CreateOrderRequest;
import com.javacode.sinatrends.dto.OrderCreatedResponse;
import com.javacode.sinatrends.dto.OrderResponseDto;
import com.javacode.sinatrends.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest) {
		
		try {
			OrderCreatedResponse order = orderService.createOrder(orderRequest);
			return ResponseEntity.ok().body(order);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("referenceId", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId) {
		try {
			List<OrderResponseDto> orderList = orderService.getOrdersByUser(userId);
			return ResponseEntity.ok().body(orderList);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
	
	@GetMapping("/reference/{referenceId}")
	public ResponseEntity<?> getOrderByReferenceId(@PathVariable String referenceId, @RequestParam Long userId) {
		try {
			OrderResponseDto order = orderService.getOrderByReference(referenceId,userId);
			return ResponseEntity.ok().body(order);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
}
