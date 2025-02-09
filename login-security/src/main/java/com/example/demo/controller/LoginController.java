package com.example.demo.controller;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.form.SignupForm;
import com.example.demo.service.UserRegistrationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final UserRegistrationService userRegistrationService;
	private static final String BASE_FRONTEND_URL = "http://localhost:8080";
	
	@GetMapping("/hi")
	public String showHi() {
		return "hi";
	}
	@GetMapping("/viewSignup")
	public String viewSignupForm() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@Valid @ModelAttribute SignupForm form,
			BindingResult bindingResult){
		/*
		 * //バリデーションチェック if(bindingResult.hasErrors()) { String errorMessage =
		 * bindingResult.getAllErrors().stream() .map(err -> err.getDefaultMessage())
		 * .collect(Collectors.joining(",")); //エラーメッセージを,で連結する return
		 * redirectToErrorPage(errorMessage); }
		 */
		//登録処理
		try {
			userRegistrationService.registerUser(form);
			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(BASE_FRONTEND_URL + "/home"))
                    .body("User registered successfully.");
		}catch(Exception ex) {
			return redirectToErrorPage(ex.getMessage());
		}
	}	
		// エラーメッセージを持ったエラーページへのリダイレクト
	    private ResponseEntity<String> redirectToErrorPage(String errorMessage) {
	        UriComponentsBuilder builder = UriComponentsBuilder
	                .fromHttpUrl(BASE_FRONTEND_URL + "/signup.html")
	                .queryParam("error", errorMessage);

	        URI errorPageUri = builder.build().encode().toUri();
	        return ResponseEntity.status(HttpStatus.FOUND)
	                .location(errorPageUri)
	                .body(errorMessage);
	    }
	
	
}
