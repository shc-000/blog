package com.shc.blog.bean;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 文章
 * @author shc
 */

@SuppressWarnings("serial")
@Entity
@Table(name="article")
@org.hibernate.annotations.Table(appliesTo = "article")
@Cacheable
public class Article implements Serializable{
	@Id
	@Column(name="article_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer articleId;
	@Column(name = "article_content")
	private String articleContent;
	
	@Column(name = "visit_count")
	private String visitCount;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	

	public String getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(String visitCount) {
		this.visitCount = visitCount;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleContent="
				+ articleContent + ", visitCount=" + visitCount + "]";
	}

	
}
