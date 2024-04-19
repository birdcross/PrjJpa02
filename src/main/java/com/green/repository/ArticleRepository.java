package com.green.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.green.entity.Article;

public interface ArticleRepository 
    extends CrudRepository<Article, Long> {
	
	// ArticleController 79 line 형변환 해결방법
	   // 상속관계를 이용하여 List를 Iterable 로 UpCasting 하여 형변하지 않음
	   // Iterable(I) <- Collection(C) <- List(I) <- ArrayList(C)
	   // 아래 내용 추가
	
	   @Override
	   ArrayList<Article> findAll();
	   
}
