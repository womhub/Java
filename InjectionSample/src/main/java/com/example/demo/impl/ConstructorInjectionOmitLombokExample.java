package com.example.demo.impl;

import org.springframework.stereotype.Component;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor //このクラスのfinalフィールドのみを引数とするコンストラクタを自動生成
public class ConstructorInjectionOmitLombokExample implements Example {
	private final SomeService someService;
	
	//コンストラクタが（自動生成される）１つのみなので省略可能
	
	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		someService.doService();
	}

}
