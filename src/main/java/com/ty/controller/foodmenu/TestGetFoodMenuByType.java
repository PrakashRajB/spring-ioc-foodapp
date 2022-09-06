package com.ty.controller.foodmenu;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.FoodMenu;
import com.ty.service.FoodMenuService;

public class TestGetFoodMenuByType {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodMenuService menuService = (FoodMenuService) applicationContext.getBean("foodMenuService");

		List<FoodMenu> menus = menuService.getFoodMenuByType("non-veg");
		for (FoodMenu menu : menus) {
			System.out.println("Id - " + menu.getId());
			System.out.println("Name - " + menu.getName());
			System.out.println("Cost - " + menu.getCost());
			System.out.println("Description - " + menu.getDescription());
			System.out.println("--------------------------------------------");
		}
	}

}
