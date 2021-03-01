package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="roles", schema="gestion_usuario")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descripcion;

	@JsonBackReference
	@OneToMany(mappedBy = "roles")
	private List<UsuarioRoles> usuarioRoles;
	
	
	public List<UsuarioRoles> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRoles> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
