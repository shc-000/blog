package com.shc.blog.utils;

public class PageTool {

	private int pageNo;
	private Integer articleTypeId;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
	public Integer getArticleTypeId() {
		return articleTypeId;
	}

	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public PageTool(int pageNo, Integer articleTypeId) {
		super();
		this.pageNo = pageNo;
		this.articleTypeId = articleTypeId;
	}

	public PageTool(int pageNo) {
		super();
		this.pageNo = pageNo;
	}

	public PageTool() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
