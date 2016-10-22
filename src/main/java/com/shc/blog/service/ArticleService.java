package com.shc.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;
import com.shc.blog.bean.Guest;
import com.shc.blog.dao.ArticleDao;
import com.shc.blog.utils.Page;
import com.shc.blog.utils.PageTool;

@Service
@Transactional
public class ArticleService{

	@Autowired
	ArticleDao articleDao;
	
	public void save(Object obj) {
		articleDao.save(obj);
	}
	
	/**
	 * 读出文章信息
	 * @param articleId
	 * @return
	 */
	public Article getArticle(Integer articleId){
		Article article = articleDao.getArticle(articleId);
		return article;
	}
	
	/**
	 * 首页文章浏览列表
	 * @return
	 */
	public List<ArticleIntroduct> showArticle(){
		List<ArticleIntroduct> articleIntroduct_list = articleDao.getArticleIntroduct();
		return articleIntroduct_list;
	}
	
	/**
	 * 访客记录
	 */
	public int addGuestRecord(Guest guest){
		return articleDao.addGuestRecord(guest);
	}
	
	/**
	 * 文章浏览量增加
	 * @param articleId
	 */
	public void addCount(Integer articleId){
		articleDao.addCount(articleId);
	}
	
	/**
	 * 分页获取文章列表信息
	 */
	public Page<ArticleIntroduct> getPage(PageTool pTool){
		return articleDao.getPage(pTool);
	}
}
