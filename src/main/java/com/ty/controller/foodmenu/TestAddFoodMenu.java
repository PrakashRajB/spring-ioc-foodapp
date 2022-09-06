package com.ty.controller.foodmenu;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.FoodMenu;
import com.ty.service.FoodMenuService;

public class TestAddFoodMenu {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodMenuService menuService = (FoodMenuService) applicationContext.getBean("foodMenuService");

		FoodMenu menu = (FoodMenu) applicationContext.getBean("foodMenu");

		FoodMenu menu2 = menuService.addFoodMenu(menu);
		if (menu2 != null) {
			System.out.println("Data is Stored");
		} else {
			System.out.println("Data is not Stored");
		}
	}

}
