package com.raghu.todoapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserObject {

	@Column(name = "name")
	private String fullName;

	@Column(name = "email")
	@Id
	private String emailID;

	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
	private List<TodoTask> taskList;

	public List<TodoTask> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TodoTask> taskList) {
		this.taskList = taskList;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserObject [fullName=" + fullName + ", emailID=" + emailID + ", password=" + password + ", taskList="
				+ taskList + "]";
	}
	
	public void addTask(TodoTask task) {
		if(taskList == null){
			taskList = new ArrayList<>();
		}
		taskList.add(task);
		task.setUser(this);
	}
	
	public void removeTask(TodoTask task) {
		taskList.remove(task);
	}
}
