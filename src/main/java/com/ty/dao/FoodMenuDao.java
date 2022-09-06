package com.ty.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.FoodMenu;

@Component
public class FoodMenuDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public FoodMenu addFoodMenu(FoodMenu menu) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	public FoodMenu getFoodMenuById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(FoodMenu.class, id);
	}

	public List<FoodMenu> getFoodMenuByType(String type) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "SELECT m FROM FoodMenu m WHERE TYPE=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, type);

		return query.getResultList();
	}

	public List<FoodMenu> getAllFoodMenu() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "SELECT m FROM FoodMenu m";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

	public boolean deleteFoodMenubyId(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		FoodMenu menu = entityManager.find(FoodMenu.class, id);
		if (menu != null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public FoodMenu updateFoodMenu(FoodMenu menu) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		if (menu != null) {
			entityTransaction.begin();
			entityManager.merge(menu);
			entityTransaction.commit();
		}
		return menu;
	}

	public FoodMenu getFoodMenuByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "SELECT m FROM FoodMenu m WHERE NAME=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, name);

		return (FoodMenu) query.getResultList().get(0);

	}

}
