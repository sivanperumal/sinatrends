package com.javacode.sinatrends.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.javacode.sinatrends.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String path = request.getServletPath();
		String authHeader = request.getHeader("Authorization");
		
		if (path.equals("/auth/login")) {
	        filterChain.doFilter(request, response);
	        return;
	    }
		if(authHeader == null || !authHeader.startsWith("Bearer ") ) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = authHeader.substring(7);
		
		try {
			if (jwtUtils.isTokenExpired(token)) {
		        throw new RuntimeException("Token expired");
		    }
			String username = jwtUtils.extractUsername(token);
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
				if(jwtUtils.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
																		userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> responseMap = new HashMap<String, String>();
			responseMap.put("error", "Invalid token");
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(responseMap);
			
			response.getWriter().write("Invalid token");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		filterChain.doFilter(request, response);
	}

}
