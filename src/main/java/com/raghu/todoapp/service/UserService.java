package com.raghu.todoapp.service;

import java.util.List;

import com.raghu.todoapp.dto.UserDTO;
import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.entity.UserObject;

public interface UserService {
	public void saveUser(UserDTO registerUser);
	
	public UserObject getUser(String email);

	public List<TodoTask> getUserTasks(String email);
}
