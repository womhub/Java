package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.used.Greet;
/**
 * @param args
 */

//SpringBootアプリケーションのスタート地点（起動クラス）
@SpringBootApplication 
public class DiSampleApplication {

	public static void main(String[] args) {
		//自分自身のexecute()を呼ぶ
		SpringApplication.run(DiSampleApplication.class, args)
		.getBean(DiSampleApplication.class).execute(); 
	}
	
	//インターフェース（依存性を注入する箇所） インスタンスを明示的に生成せず（newしない）に変数宣言のみ！
	
	@Autowired 
	private Greet g; //springによって生成されたインスタンスを受け取るGreet型の変数（フィールド）を宣言
	
	private void execute() {
		String message = g.greeting();
		System.out.println(message);
	}
}
