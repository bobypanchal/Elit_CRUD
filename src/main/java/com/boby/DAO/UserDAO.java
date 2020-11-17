package com.boby.DAO;

import java.util.List;

import com.boby.Model.User;

public interface UserDAO {
	
	public List<User> getAllUser();
	public User findByUserId(int id);
	public boolean saveOrUpdateUser(User user);
	public boolean deleteUserById(int userId);
	
}
