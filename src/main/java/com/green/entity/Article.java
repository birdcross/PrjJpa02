package com.green.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 실제 database 의 table 구조를 만든다
// import jakarta.persistence.
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Article {
	// primary key        : @id
	// 값을 자동으로 채움 : @GeneratedValue
	@Id
	@GeneratedValue
	private  Long    id; //long : null 입력안됨 => Long
	@Column
	private  String  title;
	@Column
	private  String  content;
	
	// 생성자
	public Article(Long id, String title, String content) {		
		this.id = id;
		this.title = title;
		this.content = content;
	}

	
	// toString
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
}
