package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/*
 * DBから取得したユーザー情報をSpring Securityが認識できる形に変換するサービスクラス
 * */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User user = userService.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found" + username);
		}
		return User.builder()
				.username(user.getUsername())
				.password(user.getPasswordHash())
				.build();
	}

}
