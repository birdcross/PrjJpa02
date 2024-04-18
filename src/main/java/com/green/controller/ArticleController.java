package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.dto.ArticleDto;
import com.green.entity.Article;

@Controller
public class ArticleController {
	
	@Autowired
	private  ArticleRepository  articleRepository;
	
	@GetMapping("/articles/WriteForm")
	public  String  writeForm() {
		return "articles/write";
	}
	
	// 405 에러 : method="post" -> @GetMapping 
	//  에러 : @GetMapping("/articles/Write")
	@PostMapping("/articles/Write")
	public  String  write( ArticleDto articleDto ) {
		// 넘어온 데이터 확인
		System.out.println( articleDto.toString() );  // 책 : ArticleForm
		// db 에 저장 h2 article 테이블에 저장
		// Entity : db 의 테이블이다
		// 1.  Dto -> Entity 
		Article  article = articleDto.toEntity();
		// 2.  리포지터리(인터페이스)를 사용하여 엔티티을  저장
		Article  saved   = articleRepository.save( article );   
		
		return "redirect:/articles/List";
	}
}







