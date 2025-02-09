package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.form.SignupForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
	/*ユーザー登録を行うサービスクラス*/
	
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public void registerUser(SignupForm form) throws Exception{
		//ユーザー名 重複チェク
		if (userService.findUserByUsername(form.getUsername()) != null) {
			throw new Exception("ユーザー名がすでに存在します。");
		}
		//パスワード一致チェック
		if (! form.getPassword().equals(form.getPasswordConfirm())) {
			throw new Exception("パスワードと確認用パスワードが一致しません。");
		}
		
		//新しいユーザーエンティティの作成・保存
		User user = new User();
		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPasswordHash(passwordEncoder.encode(form.getPassword())); //パスワードはエンコードして登録する
		userService.createUser(user);
	}
	

}
