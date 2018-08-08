package com.raghu.todoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.entity.UserObject;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(UserObject registerUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(registerUser);
	}

	@Override
	public UserObject findByEmail(String userEmail) {
		UserObject user = sessionFactory.getCurrentSession().get(UserObject.class, userEmail);
		return user;
	}

	@Override
	public List<TodoTask> getTasks(String email) {
		UserObject user = null;
		try {
			user = sessionFactory.getCurrentSession()
					.createQuery("select u from UserObject u JOIN FETCH u.taskList where u.emailID=:useremail",	UserObject.class)
					.setParameter("useremail", email).getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return new ArrayList<>();
		}
		return user.getTaskList();
	}

}
