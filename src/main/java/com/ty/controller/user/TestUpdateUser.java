package com.ty.controller.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.User;
import com.ty.service.UserService;

public class TestUpdateUser {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService service = (UserService) applicationContext.getBean("userService");

		User user = service.getUserById(1);
		if (user != null) {
			user.setName("Mallikarjun");
			service.updateUser(user);
		}
	}

}
