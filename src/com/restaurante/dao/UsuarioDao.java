package com.restaurante.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.restaurante.modelo.Usuario;

import javax.inject.Inject;

public class UsuarioDao  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public Usuario busca(Integer id){
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> lista(){
		return this.manager.createQuery("select c from Usuario c", Usuario.class).getResultList();
	}
	
	public void adiciona(Usuario usuario){
		this.manager.getTransaction().begin();
		this.manager.persist(usuario);
		this.manager.getTransaction().commit();
	}
	
	public EntityManager getEntityManager() {
		return manager;
	}
}
