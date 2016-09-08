package com.shc.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shc.blog.dao.ArticleDao;

@Service
public class ArticleService{

	@Autowired
	ArticleDao articleDao;
	
	public void save(Object obj) {
		articleDao.save(obj);
	}
}
