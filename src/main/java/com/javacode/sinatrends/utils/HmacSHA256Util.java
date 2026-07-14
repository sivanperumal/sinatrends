package com.javacode.sinatrends.utils;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Util {
	private static final String HMAC_SHA256 = "HmacSHA256";
	
	public static String generateSignature(String data, String secret) throws Exception{
		
		Mac sha256Hmac = Mac.getInstance(HMAC_SHA256);

        SecretKeySpec secretKey =
                new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
                        HMAC_SHA256);

        sha256Hmac.init(secretKey);

        byte[] hash = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(hash);
		
	}
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
	}
}
