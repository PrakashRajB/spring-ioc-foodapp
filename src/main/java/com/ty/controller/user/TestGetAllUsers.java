package com.ty.controller.user;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.User;
import com.ty.service.UserService;

public class TestGetAllUsers {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService service = (UserService) applicationContext.getBean("userService");

		List<User> users = service.getAllUsers();
		applicationContext.close();

		if (!users.isEmpty()) {
			System.out.println(users);
		} else {
			System.out.println("No Data Found");
		}
	}

}
