package com.restaurante.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurante");

	@Produces
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}
}