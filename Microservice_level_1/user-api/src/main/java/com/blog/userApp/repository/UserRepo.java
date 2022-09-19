package com.blog.userApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.userApp.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
