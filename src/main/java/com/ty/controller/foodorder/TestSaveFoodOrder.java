package com.ty.controller.foodorder;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dto.FoodOrder;
import com.ty.dto.OrderItem;
import com.ty.service.FoodOrderService;

public class TestSaveFoodOrder {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodOrderService orderService = (FoodOrderService) applicationContext.getBean("foodOrderService");

		OrderItem item1 = orderService.addOrderItem(2, 1);
		OrderItem item2 = orderService.addOrderItem(4, 1);
		OrderItem item3 = orderService.addOrderItem(6, 1);
		OrderItem item4 = orderService.addOrderItem(7, 1);

		FoodOrder foodOrder = orderService.saveFoodOrder(Arrays.asList(item1, item2, item3, item4));
		if(foodOrder!=null) {
			System.out.println("Order Placed");
		}else {
			System.out.println("Order Not Placed");
		}
	}

}
