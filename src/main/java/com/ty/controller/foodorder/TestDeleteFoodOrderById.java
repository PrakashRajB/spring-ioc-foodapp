package com.ty.controller.foodorder;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.service.FoodOrderService;

public class TestDeleteFoodOrderById {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodOrderService orderService = (FoodOrderService) applicationContext.getBean("foodOrderService");

		boolean result = orderService.deleteFoodOrderById(1);
		if(result) {
			System.out.println("Deleted Successfully");
		}else {
			System.out.println("No Data found");
		}
	}

}
