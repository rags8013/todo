package com.raghu.todoapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

	@NotBlank(message = "Please enter your name")
	String fullName;

	@NotBlank(message = "Please enter your email")
	@Email(message = "Please enter a valid email")
	String emailID;

	@Size(min = 5, message = "Password must be 5 characters")
	String password;

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

}
