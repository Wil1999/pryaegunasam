package com.flores.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="usuario",schema="gestion_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	private String pass;
	
	private boolean estado;
	
	private boolean remove;

	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioRoles> usuarioRoles;
	
	@Column(name="id_persona")
	private int idPersona;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	
}
