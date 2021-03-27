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
@Table(name="menu", schema="gestion_usuario")
public class Menu {
	
	public Menu() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descripcion;
	
	private String icono;
	
	private String url;
	
	@JsonBackReference
	@OneToMany(mappedBy = "menu")
	private List<UsuRolMenu> usuRolMenu;
	

	public List<UsuRolMenu> getUsuRolMenu() {
		return usuRolMenu;
	}

	public void setUsuRolMenu(List<UsuRolMenu> usuRolMenu) {
		this.usuRolMenu = usuRolMenu;
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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
