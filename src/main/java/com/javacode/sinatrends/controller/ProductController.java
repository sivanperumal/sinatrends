package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			System.out.println(productResponse);
			return ResponseEntity.ok().body(productResponse);
			
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@GetMapping("/{slug}")
	public ResponseEntity<?> getProductDetails(@PathVariable String slug) {
		try {
			ProductResponseDto dto = productService.getProductDetailsBySlug(slug);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchProducts(
					@RequestParam(required = false) String keyword,
					@RequestParam(required = false) Integer availability,  
					@RequestParam(required = false) Double minPrice,
					@RequestParam(required = false) Double maxPrice,
					@RequestParam(defaultValue = "0") int page,
					@RequestParam(defaultValue = "20") int size  ) {
		try {
			List<ProductResponseDto> productResponse = productService.searchProducts(keyword,availability,minPrice,maxPrice,page,size);
			return ResponseEntity.ok().body(productResponse);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
}
