package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodMenuDao;
import com.ty.dto.FoodMenu;

@Component
public class FoodMenuService {

	@Autowired
	private FoodMenuDao menuDao;

	public FoodMenu addFoodMenu(FoodMenu menu) {
		return menuDao.addFoodMenu(menu);
	}

	public FoodMenu getFoodMenuById(int id) {
		return menuDao.getFoodMenuById(id);
	}

	public List<FoodMenu> getFoodMenuByType(String type) {
		return menuDao.getFoodMenuByType(type);
	}

	public List<FoodMenu> getAllFoodMenu() {
		return menuDao.getAllFoodMenu();
	}

	public boolean deleteFoodMenubyId(int id) {
		return menuDao.deleteFoodMenubyId(id);
	}

	public FoodMenu updateFoodMenu(FoodMenu menu) {
		return menuDao.updateFoodMenu(menu);
	}

	public FoodMenu getFoodMenuByName(String name) {
		return menuDao.getFoodMenuByName(name);
	}

}
