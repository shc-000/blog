package com.shc.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shc.blog.bean.Article;
import com.shc.blog.service.ArticleService;

/**
 * 文章访问控制
 * @author shc
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveArticle(Article article){
		System.out.println(article);
		articleService.save(article);
		return "articleAdd";
	}
	
}
