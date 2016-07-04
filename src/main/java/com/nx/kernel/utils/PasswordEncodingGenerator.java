package com.nx.kernel.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodingGenerator {
	
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "1234";
		System.out.println(encoder.encode(password));
		
			
	}
	
	
	public static String encoder(String pw){
		return encoder.encode(pw);
	}
	
}
