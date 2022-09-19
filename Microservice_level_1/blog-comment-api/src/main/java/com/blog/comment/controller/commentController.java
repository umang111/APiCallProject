package com.blog.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.comment.entity.Comment;
import com.blog.comment.error.PostNotFound;
import com.blog.comment.requestBody.CommentDto;
import com.blog.comment.service.CommentService;

@RestController
public class commentController {

	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/addCommentOnPost/{blogId}/{userId}")
	public Comment addComment(@PathVariable("blogId") int blogId ,@PathVariable("userId") int userId, @RequestBody CommentDto commentDto) throws PostNotFound {
		Comment postedComment = commentService.addCommentOnPost(blogId,userId,commentDto);
		return postedComment;
	}
	
	@GetMapping("/commentId/{commentId}")
	public Comment getComment(@PathVariable("commentId") int commentId) {
		Comment comment=commentService.getComment(commentId);
		return comment;
	}
	
}
