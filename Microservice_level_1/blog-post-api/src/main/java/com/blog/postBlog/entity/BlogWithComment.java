package com.blog.postBlog.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogWithComment {

	private int userId;
	
	private int blogId;
	
	private String userName;
	
	private List<Blog> blog;
	
	private List<Comments> comments;
}
