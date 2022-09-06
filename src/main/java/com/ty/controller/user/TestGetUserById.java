package com.ty.controller.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.User;
import com.ty.helper.AES;
import com.ty.service.UserService;

public class TestGetUserById {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService service = (UserService) applicationContext.getBean("userService");

		User user = service.getUserById(1);
		applicationContext.close();

		if (user != null) {
			System.out.println("Id - " + user.getId());
			System.out.println("Name - " + user.getName());
			System.out.println("Email - " + user.getEmail());
			System.out.println("Phone - " + user.getPhone());
			System.out.println("Password - " + AES.decrypt(user.getPassword()));
		} else {
			System.out.println("No Data Found");
		}

	}

}
