package com.raghu.todoapp.dao;

import com.raghu.todoapp.entity.TodoTask;

public interface TaskDAO {
	
	public void addTask(TodoTask task, String userEmail);

	public void finishTask(String taskID, String userEmail);

	public void unfinishTask(String taskID, String userEmail);

	public void deleteTask(String taskID, String userEmail);

	public void editTask(String taskID, String taskName, String userEmail);

}
