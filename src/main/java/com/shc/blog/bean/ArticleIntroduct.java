package com.shc.blog.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="article_introduct")
@org.hibernate.annotations.Table(appliesTo = "article_introduct")
@Cacheable
public class ArticleIntroduct implements Serializable{
	
	@Id
	@Column(name = "introduct_id", length = 10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer introductId;
	
	@OneToOne  
	@JoinColumn(name="articleId")  
	private Article article;
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "title", length = 50)
	private String title;
	
	@Column(name = "note", length = 100)
	private String note;
	
	@Column(name = "fa_user", length = 20)
	private String faUser;
	
	@Column(name = "fa_time", length = 20)
	private Date faTime;
	//浏览次数
	@Column(name = "fa_eye", length = 20)
	private Integer faEye;
	
	@Column(name = "add_like_count", length = 10)
	private Integer addLikeCount;

	public Integer getIntroductId() {
		return introductId;
	}

	public void setIntroductId(Integer introductId) {
		this.introductId = introductId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFaUser() {
		return faUser;
	}

	public void setFaUser(String faUser) {
		this.faUser = faUser;
	}

	public Date getFaTime() {
		return faTime;
	}

	public void setFaTime(Date faTime) {
		this.faTime = faTime;
	}

	public Integer getFaEye() {
		return faEye;
	}

	public void setFaEye(Integer faEye) {
		this.faEye = faEye;
	}

	public Integer getAddLikeCount() {
		return addLikeCount;
	}

	public void setAddLikeCount(Integer addLikeCount) {
		this.addLikeCount = addLikeCount;
	}

	@Override
	public String toString() {
		return "ArticleIntroduct [introductId=" + introductId + ", article="
				+ article + ", title=" + title + ", note=" + note + ", faUser="
				+ faUser + ", faTime=" + faTime + ", faEye=" + faEye
				+ ", addLikeCount=" + addLikeCount + "]";
	}

	
}
