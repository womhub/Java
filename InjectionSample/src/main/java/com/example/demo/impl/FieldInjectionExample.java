package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

//@Component
public class FieldInjectionExample implements Example {
	
	@Autowired
	private SomeService someService;

	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		someService.doService();
	}

}
