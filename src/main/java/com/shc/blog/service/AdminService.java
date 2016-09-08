package com.shc.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shc.blog.dao.AdminDao;
@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void save(Object obj) {
		adminDao.save(obj);
	}
}
