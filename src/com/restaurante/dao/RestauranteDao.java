package com.restaurante.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.restaurante.modelo.Restaurante;

public class RestauranteDao  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	private List<Restaurante> lista;
	private List<Restaurante> listaRandomica;
	private List<Restaurante> listaResto;
	
	
	public Restaurante busca(Integer id){
		Restaurante restaurante = manager.find(Restaurante.class, id);
		return restaurante;
	}
	
	public List<Restaurante> lista(){
		this.lista = manager.createQuery("select c from Restaurante c", Restaurante.class).getResultList();
		return this.lista;
	}
	
	
	public List<Restaurante> listaResto(Integer a, Integer b){
		Query query = manager.createQuery("select c from Restaurante c where c.id not in(:a,:b)", Restaurante.class);
		query.setParameter("a", a);
		query.setParameter("b", b);
		this.listaResto = (List<Restaurante>) query.getResultList();
		return this.listaResto;
	}
	public List<Restaurante> listaRandomica(Integer a, Integer b){

		Restaurante a1 = this.busca(a);
		Restaurante a2= this.busca(b);
		
		this.listaRandomica = new ArrayList<>();
		this.listaRandomica.add(a1);
		this.listaRandomica.add(a2);
		return this.listaRandomica;
	}
	
	public void atualiza(Restaurante restaurante) {
		manager.getTransaction().begin();
		manager.merge(restaurante);
		manager.getTransaction().commit();
	}

	public EntityManager getEntityManager() {
		return manager;
	}
	
}
