package com.boby.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boby.DAO.UserDAO;
import com.boby.Model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;

	@Override
	public User findByUserId(int id) {
		return userDAO.findByUserId(id);
	}
	
	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public boolean saveOrUpdateUser(User user) {
		return userDAO.saveOrUpdateUser(user);
	}

	@Override
	public boolean deleteUserById(int userId) {
		return userDAO.deleteUserById(userId);
	}
	
	
	
}
