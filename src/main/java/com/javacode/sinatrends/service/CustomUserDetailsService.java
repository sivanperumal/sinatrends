package com.javacode.sinatrends.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.javacode.sinatrends.entity.Users;
import com.javacode.sinatrends.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found by this "+ username));
		return new User(user.getEmail(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
	}

}
