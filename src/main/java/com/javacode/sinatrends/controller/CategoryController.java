package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.sinatrends.dto.CollectionResponseDto;
import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.entity.Category;
import com.javacode.sinatrends.service.CategoryService;
import com.javacode.sinatrends.service.CollectionService;
import com.javacode.sinatrends.service.ProductService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private  CollectionService collectionService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		try {
			Category categoryItem = categoryService.createCategory(category);
			return ResponseEntity.ok().body(categoryItem);
		}
		catch(Exception e) {
			Map<String,String>responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategories() {
		List<Category> categorise = categoryService.getAllCategories();
		return ResponseEntity.ok().body(categorise);
	}
	
	@PatchMapping("/{category_slug}")
	public ResponseEntity<?> updateCategory(@PathVariable String category_slug, @RequestBody Category updtateCategoryItems) {
		try {
			Category category = categoryService.updateCategory(category_slug,updtateCategoryItems);
			return ResponseEntity.ok().body(category);
		}
		catch(Exception e) {
			Map<String,String>responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
	
	@GetMapping("/{catergory_slug}/collections")
	public ResponseEntity<?> getCollectionsByCategory(@PathVariable String catergory_slug) {
		try {
			List<CollectionResponseDto> collections = collectionService.getCollectionByCategorySlug(catergory_slug);
			return ResponseEntity.ok().body(collections);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String,String>responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@GetMapping("/{catergory_slug}/products")
	public ResponseEntity<?> getProductsByCategory(@PathVariable String catergory_slug) {
		try {
			List<ProductResponseDto> productsList = productService.getProductsByCategorySlug(catergory_slug);
			return ResponseEntity.ok().body(productsList);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String,String>responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
		
	}
}
