package com.blog.userApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.userApp.entity.User;
import com.blog.userApp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		User savedUser =userService.saveUserToDB(user);
		return savedUser;
	}
	
	@GetMapping("/getUseById/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		User userById=userService.getUserById(userId);
		return userById;
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		User updatedUser=userService.updateUser(userId,user);
		return updatedUser;
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
	}
}




















