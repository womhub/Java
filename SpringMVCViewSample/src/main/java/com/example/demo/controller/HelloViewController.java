package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller  //インスタンス生成 HTTPリクエストを受け付けてビジネスロジックを呼び出し，レスポンスを返す
@RequestMapping("hello") //リクエストハンドラメソッドのURLへのマッピング。value属性（＝URL）を指定する
public class HelloViewController {
	
	@GetMapping("view") //HTTPリクエストのGETメソッド用のリクエストハンドラメソッド
	public String helloView() {
		return "hello"; //戻り値はビュー名 （htmlファイル名）
	}
	
	@GetMapping("model")
	public String helloModel(Model model) {
		model.addAttribute("msg", "タイムリーフ！");
		return "helloTymeleaf";
	}
	
	@GetMapping("modelandview")
	public ModelAndView helloView2(ModelAndView modelAndView) {
		modelAndView.addObject("msg", "タイムリーフ");
		modelAndView.setViewName("helloTymeleaf");
		return modelAndView;
	}
}
