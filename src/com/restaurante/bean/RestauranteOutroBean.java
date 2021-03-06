package com.restaurante.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.restaurante.dao.RestauranteDao;
import com.restaurante.modelo.Restaurante;

@Named
@RequestScoped
public class RestauranteOutroBean implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private List<Restaurante> restaurantesResto;
	
	
	@Inject
	private InformacaoBean randomico;

	@Inject
	private RestauranteDao dao;


	private Restaurante restaurante;
	
	public Restaurante getRestaurante(){
		return this.restaurante;
	}

	
	public List<Restaurante> getRestaurantesResto(){
			this.restaurantesResto = dao.listaResto(randomico.getA(),randomico.getB());	
		return restaurantesResto;
	}
	
	
	public String usuario(Restaurante restaurante){
		this.registraVoto(restaurante);
		this.randomico.setRestaurantes(restaurante);
		return "usuario?faces-redirect=true";
	}


	private void registraVoto(Restaurante restaurante) {
		if(restaurante.getQtde() == null){
			restaurante.setQtde(new Integer("1"));
		}else{
			restaurante.setQtde((restaurante.getQtde()+1));
		}
		dao.atualiza(restaurante);
	}
	
}
