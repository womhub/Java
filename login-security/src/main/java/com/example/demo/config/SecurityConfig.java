package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import lombok.RequiredArgsConstructor;

@Configuration //springの設定ファイル
@EnableWebSecurity //spring securityの有効化
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // カスタム認証プロバイダを設定
            .authenticationProvider(customAuthenticationProvider)
            // CORSの設定を適用
            .cors(customizer -> customizer.configurationSource(corsConfigurationSource()))
            // CSRFの保護を無効にする（H2コンソールのみ）
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // H2コンソールへのアクセスを許可
                    .requestMatchers("/h2-console/**").permitAll()
                    // login, signupのパスへのリクエストはすべて許可
                    .requestMatchers("/login", "/signup", "/viewSignup","/js/**").permitAll()
                    // その他のリクエストは認証が必要
                    .anyRequest().authenticated()
            )
            .headers(headers -> headers
                // H2コンソールのために X-Frame-Options を無効化
                .frameOptions(frameOptions -> frameOptions.disable())
            )
            .formLogin(formLogin -> 
                formLogin
                    // ログイン処理のURLを指定(フロントがログインボタン実行時にPOSTする場所)
                    .loginProcessingUrl("/login")
                    // カスタムログインページのURLを指定(Spring Securityデフォルトの画面を置き換える)
                    .loginPage("http://localhost:8080/login")
                    // ログイン成功時のリダイレクト先URLを指定
                    .defaultSuccessUrl("http://localhost:8080/hello")
                    // 認証失敗時のリダイレクト先URLを指定
                    .failureUrl("http://localhost:8080/login")
            );
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        // CORSの設定を行うためのオブジェクトを生成
        CorsConfiguration configuration = new CorsConfiguration();
        // クレデンシャル（資格情報（CookieやHTTP認証情報））を含むリクエストを許可する
        configuration.setAllowCredentials(true);
        // 許可するオリジン（この場合は"http://localhost:8080"のみ）を設定
        configuration.addAllowedOrigin("http://localhost:8080");
        // 任意のヘッダーを許可
        configuration.addAllowedHeader("*");
        // 任意のHTTPメソッド（GET, POSTなど）を許可
        configuration.addAllowedMethod("*");
        // CORS設定をURLベースで行うためのオブジェクトを生成
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 全てのURLパスにこのCORS設定を適用
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    
   
    
}