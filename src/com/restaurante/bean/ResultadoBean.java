package com.restaurante.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.restaurante.dao.RestauranteDao;
import com.restaurante.modelo.Restaurante;

@Named
@RequestScoped
public class ResultadoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Restaurante restaurante = new Restaurante();
	
	
	private List<Restaurante> restaurantes = new ArrayList<>();
	
	
	@Inject
	private InformacaoBean randomico;

	@Inject
	private RestauranteDao dao;
	
	public Restaurante getRestaurante(){
		return this.restaurante;
	}
	
	
	public List<Restaurante> getRestaurantes(){
			restaurantes = dao.lista();

		return restaurantes;
	}

	
	public List<Restaurante> getRestaurantesEscolhidos(){
		return this.randomico.getRestaurantes();
	}
}
