package com.shc.blog.controller;

import java.io.IOException;
import java.util.Date;
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
import com.shc.blog.bean.Guest;
import com.shc.blog.service.ArticleService;
import com.shc.blog.utils.IPUtils;

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
		/*String address = IPUtils.getIpInfo(IPUtils.getIpAddr(request));//获取ip并解析为城市
		String ipAddress = IPUtils.getIpAddr(request);//ip地址
		Guest guest = new Guest(1,ipAddress,address,new Date(),1);
		articleService.addGuestRecord(guest);//访客浏览统计
*/		List<ArticleIntroduct> articleIntroduct_list = articleService.showArticle();//获取文章列表
		model.addAttribute("articleList", articleIntroduct_list); 
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
		articleService.addCount(articleId);
		modelMap.addAttribute("article", article);
		return "articleInfo";
	}
	
	/**
	 * 根据文章的分类检索不同类型的文章
	 * @return
	 */
	@RequestMapping(value="/showType/{typeId}",method=RequestMethod.GET)
	public String showTypeArticle(@PathVariable Integer typeId,ModelMap model,HttpServletRequest request, HttpServletResponse response){
		//判断typeId是否为数字或者为空的情况容错处理
		List<ArticleIntroduct> articleIntroduct_list = articleService.showTypeArticle(typeId);//根据文章类型获取文章列表
		model.addAttribute("articleList", articleIntroduct_list); 
		return "index";
	}
	
}
