package com.green.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.dto.ArticleDto;
import com.green.entity.Article;
import com.green.repository.ArticleRepository;

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
		System.out.println("saved:" + saved);
		return "redirect:/articles/List";
	}
	
	// 1번 데이터 조회 : pathVariavble -> GET
	// 1번방법 : @PathVariable(value="id")
	// 2번방버 : sts방식 프로젝트 => properties
	@GetMapping("/articles/{id}")
	public String view(@PathVariable(value="id") Long id, Model model) {
		
		//Article articleEntity = articleRepository.findById(id);
		// Type mismatch error 
		//Optional<Article> article  = articleRepository.findById(id)
		//1번방법
		Article articleEntity  = articleRepository.findById(id).orElse(null);
		// 값이 있으면 article 을 리턴하고 값이 없으면 null 리턴
		System.out.println("1번글 조회 : " + articleEntity);
		model.addAttribute("article", articleEntity);
		return "articles/view"; //view.mustache
	}
	
	
	
	
	
	
	
}







