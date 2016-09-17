package com.shc.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;

@Repository("articleDao")
public class ArticleDao {

	@Autowired
	private SessionFactory sf;
	
	public void save(Object obj) {
		sf.getCurrentSession().save(obj);
	}

	public void update(Object obj) {
		
		sf.getCurrentSession().update(obj);
	}
	
	public void delete(Object obj) {
		
		sf.getCurrentSession().delete(obj);
	}
	
	/**
	 * 通过文章id获取文章
	 * @param articleId
	 * @return
	 */
	public Article getArticle(Integer articleId) {
		Session s = sf.getCurrentSession();
		return (Article) s.get(Article.class, articleId);
	}
	
	@SuppressWarnings("unchecked")
	public List<ArticleIntroduct> getArticleIntroduct() {
		Session s = sf.getCurrentSession();
		return (List<ArticleIntroduct>) s
				.createQuery("from ArticleIntroduct order by introductId").list();
	}
}
