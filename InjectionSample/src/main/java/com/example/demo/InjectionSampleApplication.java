package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.example.Example;

@SpringBootApplication
public class InjectionSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjectionSampleApplication.class, args)
		.getBean(InjectionSampleApplication.class).exe();
	}
	
	@Autowired
	private Example example;
	
	private void exe() {
		example.run();
	}
}
