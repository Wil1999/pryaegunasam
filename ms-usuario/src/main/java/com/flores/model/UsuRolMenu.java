package com.flores.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usu_rol_menu", schema="gestion_usuario")
public class UsuRolMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean estado;

	@ManyToOne()
	@JoinColumn(name="id_usuario_rol")
	private UsuarioRoles usuarioRoles;
	
	@ManyToOne()
	@JoinColumn(name="id_menu")
	private Menu menu;
	
	public UsuarioRoles getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(UsuarioRoles usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}
