package com.boby.Service;

import java.util.List;

import com.boby.Model.User;

public interface UserService {

	public List<User> getAllUser();
	public User findByUserId(int id);
	public boolean saveOrUpdateUser(User user);
	public boolean deleteUserById(int userId);
	
}
