package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.UserDao;
import com.ty.dto.User;
import com.ty.helper.AES;

@Component
public class UserService {

	@Autowired
	private UserDao dao;

	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	public boolean deleteUserById(int id) {
		return dao.deleteUserById(id);
	}

	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	public User validateUser(String email, String password) {
		return dao.validateUser(email, AES.encrypt(password));
	}

}
