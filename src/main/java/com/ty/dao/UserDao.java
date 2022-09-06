package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.User;

@Component
public class UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public User saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return user;
	}

	public User getUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(User.class, id);
	}

	public List<User> getAllUsers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

	public boolean deleteUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public User updateUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (user != null) {
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
		}
		return user;
	}

	public User validateUser(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User u WHERE EMAIL=?1 AND PASSWORD=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> users = query.getResultList();

		return (users.isEmpty()) ? null : users.get(0);
	}

}
