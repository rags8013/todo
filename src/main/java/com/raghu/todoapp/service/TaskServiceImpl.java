package com.raghu.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.todoapp.dao.TaskDAO;
import com.raghu.todoapp.entity.TodoTask;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDAO;

	@Override
	@Transactional
	public void addTask(String taskName, String userEmail) {
		TodoTask task = new TodoTask();
		task.setTaskName(taskName);
		task.setTaskStatus(false);
		taskDAO.addTask(task, userEmail);
	}

	@Override
	public TodoTask getTask(String taskID) {
		return null;
	}

	@Override
	@Transactional
	public void finishTask(String taskID, String userEmail) {
		taskDAO.finishTask(taskID, userEmail);
	}

	@Override
	@Transactional
	public void deleteTask(String taskID, String userEmail) {
		taskDAO.deleteTask(taskID, userEmail);
	}

	@Override
	@Transactional
	public void unfinishTask(String taskID, String userEmail) {
		taskDAO.unfinishTask(taskID, userEmail);
	}

	@Override
	@Transactional
	public void editTask(String taskID, String taskName, String userEmail) {
		taskDAO.editTask(taskID, taskName, userEmail);
		
	}

}
