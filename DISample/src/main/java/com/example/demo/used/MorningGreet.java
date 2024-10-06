package com.example.demo.used;

import org.springframework.stereotype.Component;

//@Component //springが自動的にインスタンス化するクラスに付与。コンポーネントスキャン時にインスタンス化してくれる。
public class MorningGreet implements Greet {

	@Override
	public String greeting() {
		// TODO 自動生成されたメソッド・スタブ
		return "おは〜";
	}

}
