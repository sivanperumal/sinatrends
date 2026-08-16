package com.javacode.sinatrends.utils;

import java.util.Random;

public class OtpUtils {
	public static String generateOtp() {
		Random random = new Random();
		return String.format("%06d", random.nextInt(999999));
	}
}
