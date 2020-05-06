package com.bookstore.controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	private UserDAO userDAO;
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");
		entityManager=entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	public List<Users> listUser(){
		List<Users> listUsers=userDAO.listAll();
		return listUsers;
	}
}
