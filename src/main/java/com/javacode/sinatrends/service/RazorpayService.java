package com.javacode.sinatrends.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javacode.sinatrends.dto.PaymentRequest;
import com.javacode.sinatrends.dto.PaymentVerifyRequest;
import com.javacode.sinatrends.dto.RazorpayOrderResponse;
import com.javacode.sinatrends.utils.HmacSHA256Util;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class RazorpayService{
	
	@Autowired
	private RazorpayClient razorpayClient;
	
	@Value("${razorpay.key.id}")
	private String key;
	@Value("${razorpay.currency}")
	private String currency;
	@Value("${razorpay.key.secret}")
	private String secret;
	
	public RazorpayOrderResponse createOrder(PaymentRequest request) throws Exception{
		// TODO Auto-generated method stub
		JSONObject options = new JSONObject();
		options.put("amount", request.getAmount() * 100);
		options.put("currency", currency);
		options.put("receipt", "receipt_"+ System.currentTimeMillis());
		
		Order order = razorpayClient.orders.create(options);
		System.out.println(order);
		return new RazorpayOrderResponse( order.get("id"),request.getAmount(),currency,key);
		
	}


	public Boolean verifySignature(PaymentVerifyRequest request) throws Exception{
		// TODO Auto-generated method stub
		String payload = request.getRazorpayOrderId()+ "|" + request.getRazorpayPaymentId();
		
		String generatedSign = HmacSHA256Util.generateSignature(payload,secret);
		return generatedSign.equals(request.getRazorpaySignature());
	}

}
