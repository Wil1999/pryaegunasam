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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="usu_rol_menu", schema="gestion_usuario")
public class UsuRolMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean estado;
	
	@Column(name="id_usuario_rol")
	private int idUsuarioRol;
	
	@Column(name="id_menu")
	private int idMenu;

	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_usuario_rol", insertable = false, updatable = false)
	private UsuarioRoles usuarioRoles;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_menu", insertable = false, updatable = false)
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

	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
}
