package com.shc.blog.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="guest")
@org.hibernate.annotations.Table(appliesTo = "guest")
@Cacheable
public class Guest implements Serializable{
	@Id
	@Column(name = "guest_id", length = 10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer guestId;
	
	@Column(name = "guest_ip", length = 20)
	private String guestIp;
	
	@Column(name = "address", length = 30)
	private String address;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "times")
	private Integer times;
	
	@Column(name = "hacker")
	private int hacker;

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getGuestIp() {
		return guestIp;
	}

	public void setGuestIp(String guestIp) {
		this.guestIp = guestIp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
	
	public int getHacker() {
		return hacker;
	}

	public void setHacker(int hacker) {
		this.hacker = hacker;
	}

	public Guest(Integer guestId, String guestIp, String address, Date date,
			Integer times, int hacker) {
		super();
		this.guestId = guestId;
		this.guestIp = guestIp;
		this.address = address;
		this.date = date;
		this.times = times;
		this.hacker = hacker;
	}

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", guestIp=" + guestIp
				+ ", address=" + address + ", date=" + date + ", times="
				+ times + ", hacker=" + hacker + "]";
	}
	
}
