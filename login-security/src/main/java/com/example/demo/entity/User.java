package com.example.demo.entity;

import lombok.Data;

@Data 
public class User {
	private Integer id;
	private String username;
	private String passwordHash;
	private String email;
}