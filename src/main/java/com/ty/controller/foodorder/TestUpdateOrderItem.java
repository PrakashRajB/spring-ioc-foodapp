package com.ty.controller.foodorder;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.config.MyConfig;
import com.ty.dao.FoodOrderDao;
import com.ty.dto.FoodOrder;
import com.ty.dto.OrderItem;
import com.ty.service.FoodMenuService;
import com.ty.service.FoodOrderService;

public class TestUpdateOrderItem {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		FoodOrderService orderService = (FoodOrderService) applicationContext.getBean("foodOrderService");
		FoodOrderDao orderDao = (FoodOrderDao) applicationContext.getBean("foodOrderDao");
		FoodMenuService menuService=(FoodMenuService) applicationContext.getBean("foodMenuService");

		FoodOrder foodOrder = orderService.getFoodOrderById(1);

		List<OrderItem> items = foodOrder.getItems();
		for (OrderItem item : items) {
			if (item.getName().equalsIgnoreCase("egg fried rice")) {
				
				FoodOrder foodOrder2 = orderService.updateOrderedItem(1,item, 2);
				
				if (foodOrder2 != null) {
					System.out.println("FoodOrder Details");
					System.out.println("Id - " + foodOrder2.getId());
					System.out.println("Total Cost - " + foodOrder2.getCost());
					System.out.println("Ordered Date And Time - " + foodOrder2.getOrderedDateTime());
					System.out.println("---------ordered items---------");
					for (OrderItem item1 : foodOrder2.getItems()) {
						System.out.println("Item name - " + item1.getName());
						System.out.println(
								"Item cost per unit - " + menuService.getFoodMenuByName(item1.getName()).getCost());
						System.out.println("Ordered quantity - " + item1.getQuantity());
						System.out.println("------------------------------------------");
					}
				}
			}
		}

	}

}
