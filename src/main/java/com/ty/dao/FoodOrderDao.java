package com.ty.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.FoodMenu;
import com.ty.dto.FoodOrder;
import com.ty.dto.OrderItem;

@Component
public class FoodOrderDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}

	public FoodOrder getFoodOrderById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(FoodOrder.class, id);
	}

	public boolean deleteFoodOrderById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);

		if (foodOrder != null) {
			entityTransaction.begin();
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}
	
	public OrderItem addOrderItem(OrderItem orderItem) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(orderItem);
		entityTransaction.commit();

		return orderItem;
		
	}

	public OrderItem getOrderItemByName(String itemName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("SELECT o FROM  OrderItem o WHERE NAME =?1");
		query.setParameter(1, itemName);
		OrderItem item = (OrderItem) query.getResultList().get(0);
		
		return item;
	}

	public boolean removeOrderItem(OrderItem item) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(entityManager.merge(item));
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public OrderItem updateOrderItem(OrderItem orderItem) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        
		entityTransaction.begin();
		entityManager.merge(orderItem);
		entityTransaction.commit();
		return orderItem;
	}

}
