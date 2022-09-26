package com.ecomapi.service;

import java.util.List;

import com.ecomapi.entities.User;

public interface UserService {
	public boolean userRegister(User user);
	
	public User userLogin(User user);
	
	public List<User> getAllUsers();
	
	public boolean deleteUser(int userId);
	
	public User getUser(int userId);
}
