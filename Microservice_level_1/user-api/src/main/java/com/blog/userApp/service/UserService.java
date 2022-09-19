package com.blog.userApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.userApp.entity.User;
import com.blog.userApp.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User saveUserToDB(User user) {
		User savedUser=userRepo.save(user);
		return savedUser;
	}

	public User getUserById(int userId) {
		User user =userRepo.findById(userId).get();
		return user;
	}

	public User updateUser(int userId, User user) {
		
		User getUser=userRepo.findById(userId).get();
		getUser.setUserName(user.getUserName());
		getUser.setUserEmailId(user.getUserEmailId());
		getUser.setPassword(user.getPassword());
		
		User updatedUser= userRepo.save(getUser);
		return updatedUser;
		
	}

	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

}
