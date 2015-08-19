package com.restaurante.bean;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.restaurante.dao.UsuarioDao;
import com.restaurante.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public String cadastra(){
		dao.adiciona(usuario);
		return "resultado?faces-redirect=true";
	}
}
