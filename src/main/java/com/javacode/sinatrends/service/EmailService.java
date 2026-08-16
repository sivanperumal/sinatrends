package com.javacode.sinatrends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendOtp(String email, String otp) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("sivanananchaperumal@gmail.com");
			helper.setTo(email);
			helper.setSubject("sinatrends - Your OTP for Secure Login");
			
			String htmlContent = 
		            "<p>Use OTP <strong>" + otp + "</strong> to complete the login verification on sinatrends. " +
		            "This OTP is valid for the next 10 minutes.</p>" +
		            "<br/>" + 
		            "<p><strong>Please do not share the OTP with anyone.</strong></p>" +
		            "<p style='color: #555;'>Powered by sasitrends!</p>";
			
			helper.setText(htmlContent, true);
			sender.send(message);
			
		} catch (MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
