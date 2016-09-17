package com.shc.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;
import com.shc.blog.dao.ArticleDao;

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
}
