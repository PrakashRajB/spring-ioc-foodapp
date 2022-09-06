package com.ty.controller.foodmenu;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.service.FoodMenuService;

public class TestDeleteFoodMenu {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodMenuService menuService = (FoodMenuService) applicationContext.getBean("foodMenuService");

		boolean result = menuService.deleteFoodMenubyId(5);
		if (result) {
			System.out.println("Deleted Succesfully");
		} else {
			System.out.println("No Data Found");
		}
	}

}
