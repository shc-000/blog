package com.shc.blog.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shc.blog.bean.Article;
import com.shc.blog.bean.ArticleIntroduct;
import com.shc.blog.bean.Guest;

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
	
	/**
	 * 首页展示文章
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleIntroduct> getArticleIntroduct() {
		Session s = sf.getCurrentSession();
		return (List<ArticleIntroduct>) s
				.createQuery("from ArticleIntroduct order by introductId").list();
	}
	
	/**
	 * 根据类型展示文章
	 * @param typeId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleIntroduct> getArticleIntroductType(Integer typeId) {
		Session s = sf.getCurrentSession();
		return (List<ArticleIntroduct>) s
				.createQuery("from ArticleIntroduct where typeId =:typeId").setInteger("typeId", typeId).list();
	}
	
	/**
	 * 平台访问量累积
	 * @param guest
	 */
	public void addGuestRecord(Guest guest){
		Session s = sf.getCurrentSession();
		 String hql = "from Guest where guestIp =:guestIp";    
		 Guest guest1 = (Guest) s.createQuery(hql).setString("guestIp", guest.getGuestIp()).uniqueResult();
		 if(null == guest1){
			 save(guest);
		 }else{
			 guest1.setDate(new Date());
			 guest1.setTimes(guest1.getTimes()+1);
			 save(guest1);
		 }
	}
	
	/**
	 * 文章浏览量累积
	 * @param articleId
	 */
	public void addCount(Integer articleId){
		Session s = sf.getCurrentSession();
		String hql="update ArticleIntroduct ai set ai.faEye=faEye+1 where ai.articleId=:articleId";
		Query query = s.createQuery(hql).setInteger("articleId",articleId); 
		query.executeUpdate();
	}
}
