package com.example.rest.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.domain.Article;

@RestController
public class ArticleController {
	
	@GetMapping("/article/{id}")
	public Article getArticleInJson(@PathVariable int id) {
		Article article = new Article(id, "Article #"+id, LocalDateTime.now());		
		return article; 	
	}

	@GetMapping("/articles")
	public List<Article> getArticlesInJson() {
		List<Article> articles = List.of(
			new Article(1, "Article #1", LocalDateTime.now()),
			new Article(2, "Article #2", LocalDateTime.now())
		);
		return articles; 
	}

	@PostMapping("/articles")
	public List<Article> postArticlesInJson(@RequestBody List<Article> articles) {
		System.out.println(articles.toString());
		
		articles.get(0).setContent("Updated Article #1"); // 첫 번째 Article의 content 값 변경
		return articles;
	}
}
