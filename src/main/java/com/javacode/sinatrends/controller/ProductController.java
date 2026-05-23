package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		try {
			List<ProductResponseDto> productResponse = productService.getAllProducts();
			return ResponseEntity.ok().body(productResponse);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
}
