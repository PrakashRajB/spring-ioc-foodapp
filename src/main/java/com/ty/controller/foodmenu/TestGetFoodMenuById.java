package com.ty.controller.foodmenu;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.FoodMenu;
import com.ty.helper.AES;
import com.ty.service.FoodMenuService;

public class TestGetFoodMenuById {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodMenuService menuService = (FoodMenuService) applicationContext.getBean("foodMenuService");

		FoodMenu menu = menuService.getFoodMenuById(2);
		if (menu != null) {
			System.out.println("Id - " + menu.getId());
			System.out.println("Name - " + menu.getName());
			System.out.println("Cost - " + menu.getCost());
			System.out.println("Type - " + menu.getType());
			System.out.println("Description - " + menu.getDescription());
		} else {
			System.out.println("No Data Found");
		}
	}

}
