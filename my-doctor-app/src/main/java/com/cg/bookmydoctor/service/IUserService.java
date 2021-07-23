package com.cg.bookmydoctor.service;

import java.util.List;

import com.cg.bookmydoctor.dto.User;

public interface IUserService 
{
	public boolean validateUser(User user);
	public User addUser(User user);
	public void removeUser(int userId);
	public User updateUser(int userId,User user);
	public List<User> getAll();
	public User fetchById(int userId);
	public List<User> getByRole(String role);

}
