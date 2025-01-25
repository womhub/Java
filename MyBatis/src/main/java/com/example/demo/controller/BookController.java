package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	private final BookMapper bookMapper;
	
	//メニュー画面の表示
	@GetMapping("/")
	public String showIndex() {
		return "book/index";
	}
	//すべての書籍を取得する
	@GetMapping("/list")
	public String showAllBooks(Model model) {
		model.addAttribute("message", "一覧表示");
		model.addAttribute("books", bookMapper.getAllBooks());
		return "book/success";
	}
	
	//特定のIDを持つ書籍を取得する
	@GetMapping("/detail/{id}")
	public String showBook(@PathVariable("id") int id, Model model) {
		model.addAttribute("message", "詳細表示");
		model.addAttribute("book", bookMapper.getBookById(id));
		return "book/success";
	}
	
	//新しい書籍を作成する
	@GetMapping("/create")
	public String createBook(Model model) {
		Book book = new Book();
		book.setBookTitle("おさる");
		book.setAuthor("ジョージ");
		bookMapper.insertBook(book);
		model.addAttribute("message", "登録成功");
		return "book/success";
	}
	
	@GetMapping("/update/{id}")
	public String updateBook(@PathVariable("id") int id, Model model) {
		Book book = new Book();
		book.setId(id);
		book.setBookTitle("おさるのジョージ");
		book.setAuthor("更新したサル");
		bookMapper.updateBook(book);
		model.addAttribute("message", "更新成功");
		return "book/success";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		bookMapper.deleteBookById(id);
		model.addAttribute("message", "削除成功");
		return "book/success";
	}
}
