package com.example.demo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String time;
	private String title;
	private String link;
	private String user;
	public String  getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	

}
