package com.ty.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodMenuDao;
import com.ty.dao.FoodOrderDao;
import com.ty.dto.FoodMenu;
import com.ty.dto.FoodOrder;
import com.ty.dto.OrderItem;

@Component
public class FoodOrderService {

	@Autowired
	private FoodMenuDao menuDao;
	@Autowired
	private FoodOrderDao orderDao;

	public OrderItem addOrderItem(int foodMenuId, int quantity) {
		FoodMenu menu = menuDao.getFoodMenuById(foodMenuId);
		OrderItem item = new OrderItem();
		item.setName(menu.getName());
		item.setQuantity(quantity);
		item.setCost(menu.getCost() * quantity);
		OrderItem item2 = orderDao.addOrderItem(item);
		return item2;
	}

	public FoodOrder removeOrderItem(int foodId, String itemName) {
		FoodOrder foodOrder = getFoodOrderById(foodId);
		List<OrderItem> items = foodOrder.getItems();

		for (OrderItem orderItem : items) {
			if (orderItem.getName().equalsIgnoreCase(itemName)) {

				boolean result = orderDao.removeOrderItem(orderItem);

				if (result) {
					if (items.remove(orderItem)) {

						foodOrder.setItems(items);
						foodOrder.setCost(foodOrder.getCost() - orderItem.getCost());
						FoodOrder foodOrder2 = orderDao.updateFoodOrder(foodOrder);
						return foodOrder2;
					}
				}
			}
		}
		return null;
	}

	public FoodOrder updateOrderedItem(int foodOrderId, OrderItem orderItem, int orderQuantity) {

		if (orderItem != null) {
			FoodOrder foodOrder = orderDao.getFoodOrderById(foodOrderId);

			foodOrder.setCost(foodOrder.getCost() - orderItem.getCost());

			List<OrderItem> items = foodOrder.getItems();

			for (OrderItem item : items) {
				if (item.getId() == orderItem.getId()) {
					item.setQuantity(orderQuantity);
					item.setCost(menuDao.getFoodMenuByName(orderItem.getName()).getCost() * orderQuantity);
					foodOrder.setItems(items);
					foodOrder.setCost(foodOrder.getCost() + item.getCost());
					return orderDao.updateFoodOrder(foodOrder);
				}
			}
		}
		return null;
	}

	public FoodOrder saveFoodOrder(List<OrderItem> items) {
		FoodOrder foodOrder = new FoodOrder();

		Double totalItemsPrice = items.stream().collect(Collectors.summingDouble(item -> item.getCost()));

		foodOrder.setStatus("Ordered");
		foodOrder.setItems(items);
		foodOrder.setCost(totalItemsPrice);

		return orderDao.saveFoodOrder(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		return orderDao.getFoodOrderById(id);
	}

	public boolean deleteFoodOrderById(int id) {
		return orderDao.deleteFoodOrderById(id);
	}

}
