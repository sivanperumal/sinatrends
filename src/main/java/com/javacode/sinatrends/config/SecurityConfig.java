package com.javacode.sinatrends.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.javacode.sinatrends.security.JwtFilter;
import com.javacode.sinatrends.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http.authorizeHttpRequests(authz-> {
			authz.requestMatchers(HttpMethod.POST,"/api/users").permitAll()
				 .requestMatchers("/api/users").authenticated()
				 .requestMatchers("/api/me").authenticated()
				 .requestMatchers("/auth/login").permitAll()
				 .requestMatchers("/auth/refresh").permitAll()
				 .anyRequest().authenticated();
		    })
			.cors(cors->{})
			.csrf(csrf->csrf.disable())
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	   return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(daoAuthenticationProvider());
	}
	
}
