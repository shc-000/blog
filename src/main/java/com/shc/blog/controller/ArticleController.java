package com.shc.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;
import com.shc.blog.service.ArticleService;
import com.shc.blog.utils.Page;
import com.shc.blog.utils.PageTool;

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
	 * 显示首页文章简介列表
	 * @param article
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showArticle(ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		PageTool pTool = new PageTool(pageNo);
		Page<ArticleIntroduct> page = articleService.getPage(pTool);
		model.addAttribute("articleList", page); 
//		List<ArticleIntroduct> articleIntroduct_list = articleService.showArticle();//获取文章列表
//		model.addAttribute("articleList", articleIntroduct_list); 
		return "common/index";
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
		articleService.addCount(articleId);
		modelMap.addAttribute("article", article);
		return "articleInfo";
	}
	
	/**
	 * 根据文章的分类检索不同类型的文章
	 * @return
	 */
	@RequestMapping(value="/showType/{typeId}",method=RequestMethod.GET)
	public String showTypeArticle(@PathVariable String typeId,ModelMap model,HttpServletRequest request, HttpServletResponse response){
		System.out.println(typeId);
		//如果乱改后缀，让其进入404页面
		boolean result=typeId.matches("[0-9]+");
		if (true == result) {//数字格式
			Integer Id = Integer.parseInt(typeId);
			//判断typeId是否为数字或者为空的情况容错处理
			String pageNoStr = request.getParameter("pageNo");
			int pageNo = 1;
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {}
			PageTool pTool = new PageTool(pageNo,Id);
			Page<ArticleIntroduct> page = articleService.getPage(pTool);
			model.addAttribute("articleList", page); 
			return "common/index";
		}else {
			return "common/404";
		}
	}
	
}
