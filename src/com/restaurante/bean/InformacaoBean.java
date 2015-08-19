package com.restaurante.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.restaurante.modelo.Restaurante;

@Named
@SessionScoped
public class InformacaoBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Integer a;
	private Integer b;
	
	private List<Restaurante> restaurantes;
	
	public String getPopular(){
		
		this.setA(new Double((Math.random()*5)+1).intValue());
		
		this.setB(new Double((Math.random()*5)+1).intValue());
		
		while(this.getA() == this.getB()){
			this.setB(new Double((Math.random()*5)+1).intValue());	
		}	
		
		restaurantes = new ArrayList<>();
		return "";
	}
	
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	

}
