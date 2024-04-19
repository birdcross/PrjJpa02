package com.green.dto;

import com.green.entity.Article;

public class ArticleForm {

	private Long id;
	private String title;
	private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArticleForm(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	@Override
	public String toString() {
		return "ArticleForm [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	public Article toEntity() {
		return new Article(id, title, content);
	}
	
}
