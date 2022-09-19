package com.blog.comment.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.comment.ApiCallBody.Blog;
import com.blog.comment.ApiCallBody.User;
import com.blog.comment.entity.Comment;
import com.blog.comment.error.PostNotFound;
import com.blog.comment.repository.CommentRepo;
import com.blog.comment.requestBody.CommentDto;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class CommentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CommentRepo commentRepo;

	public Comment addCommentOnPost(int blogId, int userId, CommentDto commentDto) throws PostNotFound {
		
		//callForUser
		User user=restTemplate.getForObject("http://localhost:9091/getUseById/"+userId,User.class);
		Blog blog =restTemplate.getForObject("http://localhost:9092/getBlogPost/"+ blogId, Blog.class);
		
		Optional<Blog> blogOptional=Optional.of(blog);
//		Optional<User> userOptional =Optional.of(user);
		if(!(blog.getUserId()==userId)) {
			log.error("user id is wrong for this blog");
			throw new PostNotFound("user id is wrong for blog " +blogId);
		}
		Comment comment=new Comment();
		if(!blogOptional.isPresent()) {
			log.error("blog not found cannot add comment");
			throw new PostNotFound("post Not found With Id: " +blogId);
		}
		comment.setBlogId(blogId);
		comment.setUserId(user.getUserId());
		comment.setUserName(user.getUserName());
		comment.setCommentContent(commentDto.getCommentContent());
		
		Comment savedComment=commentRepo.save(comment);
		return savedComment;
	}

	public Comment getComment(int commentId) {
		Comment comment =commentRepo.findById(commentId).get();
		return comment;
	}

	
}
