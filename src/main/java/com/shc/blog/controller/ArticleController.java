package com.shc.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;
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
	
	/**
	 * 显示文章简介列表
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showArticle(ModelMap model){
		System.out.println("asd");
		List<ArticleIntroduct> articleIntroduct_list = articleService.showArticle();
		System.out.println(articleIntroduct_list);
		model.addAttribute("articleList", articleIntroduct_list); 
		System.out.println("咋");
		return "index";
	}
	
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveArticle(Article article){
		System.out.println(article);
		articleService.save(article);
		return "articleAdd";
	}
	
	/**
	 * 查看文章
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/check/{articleId}")
	public String checkArticle(@PathVariable Integer articleId,ModelMap modelMap){
		Article article = articleService.getArticle(articleId);
		modelMap.addAttribute("article", article);
		return "articleInfo";
	}
	
}
