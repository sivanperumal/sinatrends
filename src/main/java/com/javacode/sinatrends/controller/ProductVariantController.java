package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javacode.sinatrends.dto.CreateProductVariantDto;
import com.javacode.sinatrends.dto.ProductVariantResponseDto;
import com.javacode.sinatrends.service.ProductVariantService;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {
	@Autowired
	private ProductVariantService productVariantService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateProductVariantDto variantDto) {
		try {
			ProductVariantResponseDto variantResponse = productVariantService.createProductVariant(variantDto);
			return ResponseEntity.ok().body(variantResponse);
			
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@DeleteMapping("/{variantId}")
	public ResponseEntity<?> delete(@PathVariable Long variantId) {
		try {
			String message = productVariantService.deleteProductVariant(variantId);
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", message);
			return ResponseEntity.ok().body(responseMap);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
}
