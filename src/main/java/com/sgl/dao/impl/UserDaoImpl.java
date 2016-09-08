package com.sgl.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgl.dao.UserDaoI;

@Repository("userDao")
public class UserDaoImpl<T> implements UserDaoI<T> {
	//注入sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	
	public Serializable save(T o) {
		System.out.println("mm");
		System.out.println(sessionFactory.getCurrentSession().toString());
		System.out.println(o.toString());
		System.out.println(sessionFactory.getCurrentSession().save(o));
		sessionFactory.getCurrentSession().save(o);
		System.out.println("ok");
		return null;
	}

}
