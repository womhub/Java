package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {
	
	@GetMapping("show")
	public String showView() {
		return "input";
	}
	
	@GetMapping("result")
	public String showResultGet(
			@RequestParam(name = "val") String val, Model model) { //HTTPリクエストのname="val"であるパラメータを受け取り，modelに格納する
		model.addAttribute("value", val);
		return "output";
	}
	
	@PostMapping("result")
	public String showResultPost(
			@RequestParam(name = "val") String val, Model model) {
		model.addAttribute("value", val);
		return "output";
	}	
}
