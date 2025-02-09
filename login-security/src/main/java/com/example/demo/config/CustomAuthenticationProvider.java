package com.example.demo.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/*
 * デフォルトのログイン認証の機能をカスタマイズするためのクラス*/
@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    
    /*
     * 認証本処理
     * @param Authentication型の認証リクエストオブジェクト
     * @return Authentication型の権限の情報を含む認証されたオブジェクト */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	//入力されたユーザー名，パスワードを取得
        String username = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();
        
        //ユーザー名からユーザーを探索する
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        //入力されたパスワードをエンコードしたものと，登録されているエンコード済みのパスワードを比較する
        //合致していればユーザー名，パスワード，権限情報をもったオブジェクトを返す
        if (passwordEncoder.matches(inputPassword, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, inputPassword, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // authentication(認証方式)がUsernamePasswordAuthenticationToken.class(ユーザー名とパスワード認証)か判定
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
