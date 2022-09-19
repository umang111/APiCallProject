package com.blog.comment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_comment")
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="blog_id")
	private int blogId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="comment_content")
	private String commentContent;	
	

}