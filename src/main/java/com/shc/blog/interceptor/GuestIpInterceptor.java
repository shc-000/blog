package com.shc.blog.interceptor;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shc.blog.bean.Guest;
import com.shc.blog.service.ArticleService;
import com.shc.blog.utils.IPUtils;

public class GuestIpInterceptor extends HandlerInterceptorAdapter implements InitializingBean, ApplicationContextAware{
	
	@Autowired
	private ArticleService articleService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		String address = IPUtils.getIpInfo(IPUtils.getIpAddr(request));//获取ip并解析为城市
		String ipAddress = IPUtils.getIpAddr(request);//ip地址
		//这里要查询判断这个ip地址是否具有攻击性，如果有就将其设为黑名单客户
		Guest guest = new Guest(1,ipAddress,address,new Date(),1,0);
		int hacker = articleService.addGuestRecord(guest);//访客浏览统计
		if (hacker == 1) {
			return false;
		}
		return true;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
