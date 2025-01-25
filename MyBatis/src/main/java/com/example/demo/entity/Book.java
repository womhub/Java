package com.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class Book {
	private int id;
	
	private String bookTitle;
	
	private String author;
	
	private Publisher publisher;
	
	private List<Review> reviews;
}
