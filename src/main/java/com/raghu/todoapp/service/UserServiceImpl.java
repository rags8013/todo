package com.raghu.todoapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.todoapp.dao.UserDAO;
import com.raghu.todoapp.dto.UserDTO;
import com.raghu.todoapp.entity.TodoTask;
import com.raghu.todoapp.entity.UserObject;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void saveUser(UserDTO registerUser) {
		// Check if user exits
		UserObject userObj = new UserObject();
		userObj.setEmailID(registerUser.getEmailID());
		userObj.setFullName(registerUser.getFullName());
		userObj.setPassword(passwordEncoder.encode(registerUser.getPassword()));
		userDao.saveUser(userObj);
	}
	
	@Override
	@Transactional
	public UserObject getUser(String email) {
		System.out.println("in user dao");
		UserObject userObject = userDao.findByEmail(email);
		return userObject;
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserObject userObj = userDao.findByEmail(email);
		Set<GrantedAuthority> authorities = new HashSet<>();
		return new User(userObj.getEmailID(), userObj.getPassword(), authorities);
	}

	@Override
	@Transactional
	public List<TodoTask> getUserTasks(String email) {
		return userDao.getTasks(email);
	}

}
