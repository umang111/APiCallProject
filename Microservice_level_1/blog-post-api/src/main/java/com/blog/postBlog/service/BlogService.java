package com.blog.postBlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.blog.postBlog.ApiCallDto.User;
import com.blog.postBlog.entity.Blog;
import com.blog.postBlog.entity.RequestForBlog;
import com.blog.postBlog.repo.BlogRepo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepo blogRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder builder;
	
	public Blog addBlog(int userId, RequestForBlog blogContent) {
		
//		User getuser=restTemplate.getForObject("http://localhost:9091/getUseById/" + userId, User.class);
		
		User getuser=builder.build()
				.get()
				.uri("http://localhost:9091/getUseById/" + userId)
				.retrieve()
				.bodyToMono(User.class)
				.block();
		Blog blog =new Blog();
		blog.setUserId(userId);
		blog.setUserName(getuser.getUserName());
		blog.setUserEmailId(getuser.getUserEmailId());
		blog.setBlogTitle(blogContent.getBlogTitle());
		blog.setBlogContent(blogContent.getBlogContent());
		Blog savedBlog=blogRepo.save(blog);
		return savedBlog;
	}
	
	public Blog getBlogPost(int blogId) {
		
		Blog blog =blogRepo.findById(blogId).get();
		return blog;
	}
	
	public Blog updateBlogPost(int blogId, Blog blog) {
		Blog getBlog=blogRepo.findById(blogId).get();
		getBlog.setBlogTitle(blog.getBlogTitle());
		getBlog.setBlogContent(blog.getBlogContent());
		
		Blog updatedBlog=blogRepo.save(getBlog);
		return updatedBlog;
	}
	
	public void deleteBlogPost(int blogId) {
		blogRepo.deleteById(blogId);
	}

	public List<Blog> getBlogWithUserId(int userId) {
		List<Blog> getBlog=blogRepo.findByUserId(userId);
		return getBlog;
	}

}
