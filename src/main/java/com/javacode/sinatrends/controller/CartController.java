package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javacode.sinatrends.dto.*;
import com.javacode.sinatrends.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCart(@RequestBody CartRequestDto cartRequest) {
		try {
			CartResponse cartResponse =  cartService.addCartByUser(cartRequest);
			return ResponseEntity.ok().body(cartResponse);
		} catch (Exception e) {
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
			// TODO: handle exception
		}
		
	}
	
	@GetMapping("/user/{user_id}")
	public ResponseEntity<?> getCart(@PathVariable Long user_id) {
		try {
			CartResponse cartResponse = cartService.getCartByUser(user_id);
			return ResponseEntity.ok().body(cartResponse);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@PatchMapping("/{cart_id}")
	public ResponseEntity<?> updateCart(@PathVariable Long cart_id, @RequestParam Long user_id, @RequestParam Integer quantity) {
		try {
			CartResponse cartProducts = cartService.updateCartByUserId(cart_id,user_id, quantity);
			return ResponseEntity.ok().body(cartProducts);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@DeleteMapping("/{cart_id}")
	public ResponseEntity<?> removeCart(@PathVariable Long cart_id, @RequestParam Long user_id) {
		try {
			CartResponse cartProducts = cartService.removeCartByCartId(cart_id,user_id);
			return ResponseEntity.ok().body(cartProducts);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}

}
