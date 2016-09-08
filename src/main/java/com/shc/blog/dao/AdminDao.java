package com.shc.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDao {

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
}
