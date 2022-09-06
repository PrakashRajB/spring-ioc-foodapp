package com.ty.controller.foodorder;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.FoodOrder;
import com.ty.dto.OrderItem;
import com.ty.service.FoodMenuService;
import com.ty.service.FoodOrderService;

public class TestGetFoodOrderById {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodOrderService orderService = (FoodOrderService) applicationContext.getBean("foodOrderService");
		FoodMenuService menuService = (FoodMenuService) applicationContext.getBean("foodMenuService");

		FoodOrder foodOrder = orderService.getFoodOrderById(1);
		if (foodOrder != null) {
			System.out.println("FoodOrder Details");
			System.out.println("Id - " + foodOrder.getId());
			System.out.println("Total Cost - " + foodOrder.getCost());
			System.out.println("Ordered Date And Time - " + foodOrder.getOrderedDateTime());
			System.out.println("---------ordered items---------");
			for (OrderItem item : foodOrder.getItems()) {
				System.out.println("Item name - " + item.getName());
				System.out.println("Item cost per unit - " + menuService.getFoodMenuByName(item.getName()).getCost());
				System.out.println("Ordered quantity - " + item.getQuantity());
				System.out.println("------------------------------------------");
			}
		}
	}

}
