package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

@Component
public class ConstructorInjectionExample implements Example {
	private final SomeService someService;
	
	@Autowired //コンストラクタインジェクション（アノテーションは省略可能）
	public ConstructorInjectionExample(SomeService someService) {
		this.someService = someService;
	}
	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		someService.doService();
	}
}
