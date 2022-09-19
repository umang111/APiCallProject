package com.blog.postBlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blogData")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Blog {

	@Id
	@GeneratedValue
	@Column(name="blog_id")
	private int blogId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmailId;
	
	@Column(name="blog_title")
	private String blogTitle;	
	
	@Column(name="blog_content")
	private String blogContent;
}
