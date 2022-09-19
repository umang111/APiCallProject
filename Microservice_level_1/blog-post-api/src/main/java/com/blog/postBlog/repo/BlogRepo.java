package com.blog.postBlog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.postBlog.entity.Blog;

public interface BlogRepo extends JpaRepository<Blog,Integer>{

	List<Blog> findByUserId(int userId);

}
