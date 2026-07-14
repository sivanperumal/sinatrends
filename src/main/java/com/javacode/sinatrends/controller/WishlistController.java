package com.javacode.sinatrends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.dto.WishlistRequestDto;
import com.javacode.sinatrends.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addWishlist(@RequestBody WishlistRequestDto WishlistRequest) {
		try {
			List<ProductResponseDto> response = wishlistService.addWishlist(WishlistRequest);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getWishList(@PathVariable Long userid) {
		try {
			List<ProductResponseDto> wishlistProducts = wishlistService.getWishlistByUserid(userid);
			return ResponseEntity.ok().body(wishlistProducts);
			 
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
	
	@DeleteMapping("/{userid}/{productid}")
	public ResponseEntity<?> removeWishList(@PathVariable Long userid,@PathVariable Long productid) {
		try {
			List<ProductResponseDto> wishlistProducts= wishlistService.removeWishListByUserandProduct(userid,productid);
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put("message", "Wishlist product removed successfully");
			responseMap.put("products", wishlistProducts);
			return ResponseEntity.ok().body(responseMap);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("message", e.getMessage());
			return ResponseEntity.badRequest().body(responseMap);
		}
	}
}
