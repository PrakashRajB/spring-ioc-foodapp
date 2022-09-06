package com.ty.controller.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.service.UserService;

public class TestDeleteUserById {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService service = (UserService) applicationContext.getBean("userService");

		boolean result = service.deleteUserById(2);
		applicationContext.close();
		if (result) {
			System.out.println("Deleted Succesfully");
		} else {
			System.out.println("No Data Found");
		}
	}

}
