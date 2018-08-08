package com.raghu.todoapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.entity.UserObject;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTask(TodoTask task, String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		session.save(task);
		UserObject user = session.get(UserObject.class, userEmail);
		user.addTask(task);
		session.save(user);
	}

	@Override
	public void finishTask(String taskID, String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		TodoTask task = session.get(TodoTask.class, Integer.valueOf(taskID));
		if(task.getUser().getEmailID().equals(userEmail)){
			task.setTaskStatus(true);
			session.update(task);
		}
		
	}

	@Override
	public void unfinishTask(String taskID, String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		TodoTask task = session.get(TodoTask.class, Integer.valueOf(taskID));
		if(task.getUser().getEmailID().equals(userEmail)){
			task.setTaskStatus(false);
			session.update(task);
		}
		
		
	}

	@Override
	public void deleteTask(String taskID, String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		TodoTask task = session.get(TodoTask.class, Integer.valueOf(taskID));
		if(task.getUser().getEmailID().equals(userEmail)){
			session.delete(task);
		}
		
	}

	@Override
	public void editTask(String taskID, String taskName, String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		TodoTask task = session.get(TodoTask.class, Integer.valueOf(taskID));
		if(task.getUser().getEmailID().equals(userEmail)){
			task.setTaskName(taskName);
			session.update(task);
		}
		
	}
}
