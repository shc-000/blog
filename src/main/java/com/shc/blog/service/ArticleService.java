package com.shc.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shc.blog.dao.ArticleDao;

@Service
@Transactional
public class ArticleService{

	@Autowired
	ArticleDao articleDao;
	
	public void save(Object obj) {
		articleDao.save(obj);
	}
}
