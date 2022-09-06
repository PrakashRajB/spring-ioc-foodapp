package com.ty.controller.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.User;
import com.ty.helper.AES;
import com.ty.service.UserService;

public class TestSaveUser {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService service = (UserService) applicationContext.getBean("userService");
		User user = (User) applicationContext.getBean("user");

		user.setName("Manoj");
		user.setEmail("manoj@gmail.com");
		user.setPassword(AES.encrypt("asdf"));
		user.setPhone(9080919271l);

		User user2 = service.saveUser(user);
		applicationContext.close();

		if (user2 != null) {
			System.out.println("Data is Stored");
		} else {
			System.out.println("Data is not Stored");
		}

	}

}
