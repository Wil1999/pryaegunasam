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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ubigeo_departamento",schema ="general")
public class UbigeoDepartamento {
	
	public UbigeoDepartamento() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ubigeoDepartamento")
	private List<UbigeoProvincia> ubigeoProvincia;

	
	public List<UbigeoProvincia> getUbigeoProvincia() {
		return ubigeoProvincia;
	}

	public void setUbigeoProvincia(List<UbigeoProvincia> ubigeoProvincia) {
		this.ubigeoProvincia = ubigeoProvincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
