package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Ctrl+Shift+O: 勝手にインポートしてくれる
//Ctrl+O: メソッドが確認できる

@Data //ゲッター，セッター，Objectクラスのメソッドのオーバーライド
@AllArgsConstructor //全てのフィールドを引数に持つコンストラクタ
@NoArgsConstructor //引数なしのコンストラクタ
public class User {
	private String name;
	private int age;
}
