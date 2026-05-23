package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javacode.sinatrends.dto.CreateProductCollectionDto;
import com.javacode.sinatrends.dto.ProductCollectionResponseDto;
import com.javacode.sinatrends.service.ProductCollectionService;

@RestController
@RequestMapping("/api/product-collection")
public class ProductCollectionController {
	@Autowired
	private ProductCollectionService productCollectionService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateProductCollectionDto collectionDto) {
		try {
			ProductCollectionResponseDto collectionResponse = productCollectionService.createProductCollection(collectionDto);
			return ResponseEntity.ok().body(collectionResponse);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		} 
	}
}
