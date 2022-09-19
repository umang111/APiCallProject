package com.blog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.comment.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
