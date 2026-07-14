package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.OrderCreatedResponse;
import com.javacode.sinatrends.dto.PaymentRequest;
import com.javacode.sinatrends.dto.PaymentVerifyRequest;
import com.javacode.sinatrends.dto.RazorpayOrderResponse;
import com.javacode.sinatrends.service.OrderService;
import com.javacode.sinatrends.service.RazorpayService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private RazorpayService razorpayService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/create-order")
	public ResponseEntity<?> createOrder(@RequestBody PaymentRequest request) throws Exception{
		try {
			RazorpayOrderResponse response = razorpayService.createOrder(request);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@PostMapping("/verify")
	public ResponseEntity<?> verifyPayment(@RequestBody PaymentVerifyRequest request) {
		try {
			Boolean verified = razorpayService.verifySignature(request);
			if(verified) {
				OrderCreatedResponse referenceID = orderService.createOrder(request.getOrderRequest());
				return ResponseEntity.ok().body(referenceID);
			}
			else {
				return ResponseEntity.badRequest()
		                .body("Payment Verification Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
}
