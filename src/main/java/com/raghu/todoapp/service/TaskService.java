package com.raghu.todoapp.service;

import com.raghu.todoapp.entity.TodoTask;

public interface TaskService {

	public void addTask(String taskName, String userEmail);

	public TodoTask getTask(String taskID);

	public void finishTask(String taskID, String userEmail);

	public void deleteTask(String taskID, String string);

	public void unfinishTask(String taskID, String name);

	public void editTask(String taskID, String taskName, String name);

}
