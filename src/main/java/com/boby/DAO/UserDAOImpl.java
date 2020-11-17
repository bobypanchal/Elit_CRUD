package com.boby.DAO;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boby.Model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> alluser = session.createQuery("from User").list();
		return alluser;
	}

	@Override
	public User findByUserId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> alluser = session.createQuery("from User where id = '" + id + "'").list();
		if(alluser.size() > 0)
			return alluser.get(0);
		else
			return null;
	}

	@Override
	public boolean saveOrUpdateUser(User user) {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUserById(int userId) {
		User user = new User();
		user.setId(userId);
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
