package com.javacode.sinatrends.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacode.sinatrends.dto.ProductResponseDto;
import com.javacode.sinatrends.dto.WishlistRequestDto;
import com.javacode.sinatrends.entity.Product;
import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.entity.Wishlist;
import com.javacode.sinatrends.mapper.ProductMapper;
import com.javacode.sinatrends.repository.ProductRepository;
import com.javacode.sinatrends.repository.UserRepository;
import com.javacode.sinatrends.repository.WishlistRepository;

@Service
public class WishlistService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductMapper productMapper;
	
	public List<ProductResponseDto> addWishlist(WishlistRequestDto wishlistRequest) {
		// TODO Auto-generated method stub
		Users user = userRepo.findById(wishlistRequest.getUserid()).orElseThrow(()-> new RuntimeException("user not found"));
		
		for(Long productId : wishlistRequest.getProducts()) {
			Boolean exists = wishlistRepo.existsByUserIdAndProductId(user.getId(), productId);
			if(!exists) {
				Product product = productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
				Wishlist wishlist = new Wishlist();
				wishlist.setUser(user);
				wishlist.setProduct(product);
				wishlistRepo.save(wishlist);
			}
		}
		
		List<Wishlist> items = wishlistRepo.findByUserId(user.getId());
		List<ProductResponseDto> favProducts = items.stream().map(wishlist->{
			ProductResponseDto productDto = productMapper.toDto(wishlist.getProduct());
			return productDto;
		}).collect(Collectors.toList());
		return favProducts;
	}

	public List<ProductResponseDto> getWishlistByUserid(Long userid) {
		// TODO Auto-generated method stub
		List<Wishlist> items = wishlistRepo.findByUserId(userid);
		List<ProductResponseDto> favProducts = items.stream().map(wishlist->{
			ProductResponseDto productDto = productMapper.toDto(wishlist.getProduct());
			return productDto;
		}).collect(Collectors.toList());
		return favProducts;
	}

	@Transactional
	public List<ProductResponseDto> removeWishListByUserandProduct(Long userid, Long productid) {
		// TODO Auto-generated method stub
		wishlistRepo.deleteByUserIdAndProductId(userid, productid);
		List<Wishlist> items = wishlistRepo.findByUserId(userid);
		List<ProductResponseDto> favProducts = items.stream().map(wishlist->{
			ProductResponseDto productDto = productMapper.toDto(wishlist.getProduct());
			return productDto;
		}).collect(Collectors.toList());
		return favProducts;
	}

}
