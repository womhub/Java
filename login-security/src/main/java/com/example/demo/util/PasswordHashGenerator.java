package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * パスワードハッシュ生成ツール*/
public class PasswordHashGenerator {
	 public static void main(String[] args) {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String rawPassword = "test123";
	        String hashedPassword = encoder.encode(rawPassword);
	        System.out.println(hashedPassword);
	    }
}
