package com.shc.blog.dao;

import java.util.ArrayList;
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
import com.shc.blog.utils.Page;
import com.shc.blog.utils.PageTool;

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
	 * 平台访问量累积
	 * @param guest
	 */
	public int addGuestRecord(Guest guest){
		Session s = sf.getCurrentSession();
		 String hql = "from Guest where guestIp =:guestIp";    
		 Guest guest1 = (Guest) s.createQuery(hql).setString("guestIp", guest.getGuestIp()).uniqueResult();
		 if(null == guest1){
			 save(guest);
		 }else{
			 guest1.setDate(new Date());
			 guest1.setTimes(guest1.getTimes()+1);
			 save(guest1);
			 if (guest1.getHacker() == 1) {
				return 1;
			 }else {
				return 0;
			}
		 }
		return 0;
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
	
	/**
	 * 分页显示招聘信息
	 */
	public Page<ArticleIntroduct> getPage(PageTool pTool) {
		Page<ArticleIntroduct> page = new Page<ArticleIntroduct>(pTool.getPageNo());
		page.setTotalItemNumber(getTotalBookNumber(pTool));
		//校验 pageNo 的合法性
		pTool.setPageNo(page.getPageNo());
		page.setList(getPageList(pTool, 5));//设置一页显示的数据量，Page文件中也要修改
		return page;
	}
	
	/**
	 * 分页显示助理--》获取指定区间内的记录数
	 * @param pTool
	 * @return
	 */
	public long getTotalBookNumber(PageTool pTool) {
		Session s = sf.getCurrentSession();
		String hql = "SELECT count(introductId) FROM ArticleIntroduct";
		Query query = s.createQuery(hql);
		Long count= (long)query.uniqueResult(); 
		return count; 
	}
	
	/**
	 * 分页显示助理2
	 * hibernate不支持limit
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleIntroduct> getPageList(PageTool pTool, int pageSize) {
		List<ArticleIntroduct> list=new ArrayList<ArticleIntroduct>();
		Session s = sf.getCurrentSession();
		String sql =null;
		Query query = null;
		if(pTool.getPageNo() <1){//防止数据不存在时出现负数
			pTool.setPageNo(1);
		}
		if (null == pTool.getArticleTypeId()) {//首页
			sql = "select *from article_introduct limit ?,?";
			query = s.createSQLQuery(sql).addEntity(ArticleIntroduct.class);
			query.setInteger(0, (pTool.getPageNo()-1)*pageSize);
			query.setInteger(1, pageSize);
		}else{//文章分类页
			sql = "select *from article_introduct where type_id = ? limit ?,?";
			query = s.createSQLQuery(sql).addEntity(ArticleIntroduct.class);
			query.setInteger(0, pTool.getArticleTypeId());
			query.setInteger(1, (pTool.getPageNo()-1)*pageSize);
			query.setInteger(2, pageSize);
		}
		list = query.list();
		return list;
		
	}
	
	
}
