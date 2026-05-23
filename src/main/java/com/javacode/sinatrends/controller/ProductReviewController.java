package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javacode.sinatrends.dto.CreateProductReviewDto;
import com.javacode.sinatrends.entity.ProductReview;
import com.javacode.sinatrends.mapper.ProductReviewMapper;
import com.javacode.sinatrends.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductReviewController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductReviewMapper reviewMapper;
	
	@PostMapping("/review")
	public ResponseEntity<?> createProductReview(@RequestBody CreateProductReviewDto reviewDto) {
		try {
			ProductReview reviewResponse = productService.createProductReview(reviewDto);
			return ResponseEntity.ok().body(reviewMapper.toReviewResponseDto(reviewResponse));
		}
		catch(Exception e) {
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
}
