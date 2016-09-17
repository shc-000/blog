package com.shc.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shc.blog.bean.Admin;
import com.shc.blog.bean.ArticleIntroduct;
import com.shc.blog.service.AdminService;

/**
 * 管理员控制
 * @author shc
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public void regAdmin(ModelAndView mav,Admin admin){
		adminService.save(admin);
	}
	
	@RequestMapping(value="/loginpre",method=RequestMethod.GET)
	public String loginpre(){
		return "login/admin";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginAdmin(ModelAndView mav,Admin admin){
		if (admin.getUser().equals("shc") && admin.getPwd().equals("shc@lzn1314")) {
			return "articleAdd";
		}
		return null;
	}
}
