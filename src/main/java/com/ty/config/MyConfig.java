package com.ty.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ty.dto.FoodMenu;

@Configuration
@ComponentScan(basePackages = "com.ty")
@PropertySource(value={"classpath:foodmenu.properties"})
public class MyConfig {

	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("vikas");
	}

	@Bean
	public FoodMenu getFoodMenu() {
		return new FoodMenu();
	}

}
