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
public class RestauranteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Restaurante restaurante = new Restaurante();
	
	private List<Restaurante> restaurantesRandomico;
	
	private List<Restaurante> restaurantesEscolhidos = new ArrayList<>();
	
	
	@Inject
	private InformacaoBean randomico;

	@Inject
	private RestauranteDao dao;
	
	public Restaurante getRestaurante(){
		return this.restaurante;
	}
	
	public List<Restaurante> getRestaurantesRandom(){

		if(restaurantesRandomico == null){
			restaurantesRandomico = dao.listaRandomica(this.randomico.getA(),this.randomico.getB());
		}
		
		return restaurantesRandomico;
	}
	
	public String escolha(Restaurante restaurante){
		if(restaurante.getQtde() == null){
			restaurante.setQtde(new Integer("1"));
		}else{
			restaurante.setQtde((restaurante.getQtde()+1));
		}
		dao.atualiza(restaurante);
		this.restaurantesEscolhidos = this.randomico.getRestaurantes();
		if (this.restaurantesEscolhidos == null) {
			this.restaurantesEscolhidos = new ArrayList<>();
		}
		this.restaurantesEscolhidos.add(restaurante);
		this.randomico.setRestaurantes(restaurantesEscolhidos);
		return "restaurante?faces-redirect=true";
	}
	
}
