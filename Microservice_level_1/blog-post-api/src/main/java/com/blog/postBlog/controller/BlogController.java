package com.blog.postBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.postBlog.entity.Blog;
import com.blog.postBlog.entity.BlogWithComment;
import com.blog.postBlog.entity.RequestForBlog;
import com.blog.postBlog.service.BlogService;

@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;

	@PostMapping("/postBlog/{userId}")
	public Blog postBlog(@PathVariable("userId") int userId, @RequestBody RequestForBlog blogContent) {
		
		Blog Addedblog=blogService.addBlog(userId,blogContent);
		
		return Addedblog;
	}
	
	@GetMapping("/getBlogPost/{blogId}")
	public Blog getBlogPost(@PathVariable("blogId") int blogId) {
		
		Blog getBlog=blogService.getBlogPost(blogId);
		return getBlog;
	}
	
	@GetMapping("/getListOfBlogWithUserId/{userId}")
	public List<Blog> BlogWithComment(@PathVariable("userId") int userId) {
		List<Blog> getBlog = blogService.getBlogWithUserId(userId);
		return getBlog;
	}
	
//	@GetMapping("/getBlogsWithCommentByUserId/{userId}")
//	public BlogWithComment getBlogWithComment(@PathVariable("userId") int userId) {
//		
//	}
	
	@PutMapping("/updateBlogPost/{blogId}")
	public Blog updateBlogPost(@PathVariable("blogId") int blogId, @RequestBody Blog blog) {
		
		Blog updatedBlog=blogService.updateBlogPost(blogId,blog);
		
		return updatedBlog;
	}
	
	@DeleteMapping("/deleteBlogPost/{blogId}")
	public void deleteBlogPost(@PathVariable("blogId") int blogId) {
		blogService.deleteBlogPost(blogId);
	}
	
}
