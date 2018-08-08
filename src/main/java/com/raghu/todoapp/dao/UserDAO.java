package com.raghu.todoapp.dao;


import java.util.List;

import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.entity.UserObject;

public interface UserDAO {
	public void saveUser(UserObject registerUser);
	UserObject findByEmail(String username);
	public List<TodoTask> getTasks(String email);
}
