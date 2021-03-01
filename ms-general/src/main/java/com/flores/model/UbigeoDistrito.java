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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ubigeo_distrito",schema ="general")
public class UbigeoDistrito {
	
	public UbigeoDistrito() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	@Column(name="id_ubi_provincia")
	private int ubigeoProvinciaId;
	
	@ManyToOne()
	@JsonManagedReference
	@JoinColumn(name="id_ubi_provincia",insertable = false, updatable = false)
	private UbigeoProvincia ubigeoProvincia;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ubigeoDistritoNac")
	private List<Persona> personaNac;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ubigeoDistritoDom")
	private List<Persona> personaDom;
	
	public List<Persona> getPersonaNac() {
		return personaNac;
	}

	public void setPersonaNac(List<Persona> personaNac) {
		this.personaNac = personaNac;
	}

	public List<Persona> getPersonaDom() {
		return personaDom;
	}

	public void setPersonaDom(List<Persona> personaDom) {
		this.personaDom = personaDom;
	}

	public UbigeoProvincia getUbigeoProvincia() {
		return ubigeoProvincia;
	}

	public void setUbigeoProvincia(UbigeoProvincia ubigeoProvincia) {
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

	public int getUbigeoProvinciaId() {
		return ubigeoProvinciaId;
	}

	public void setUbigeoProvinciaId(int ubigeoProvinciaId) {
		this.ubigeoProvinciaId = ubigeoProvinciaId;
	}
}
