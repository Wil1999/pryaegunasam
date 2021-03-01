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
@Table(name="ubigeo_provincia",schema="general")
public class UbigeoProvincia {
	
	public UbigeoProvincia() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	@Column(name="id_ubi_departamento")
	private int ubigeoDepartamentoId;
	
	@ManyToOne()
	@JsonManagedReference
	@JoinColumn(name="id_ubi_departamento", insertable = false, updatable = false)
	private UbigeoDepartamento ubigeoDepartamento;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ubigeoProvincia")
	private List<UbigeoDistrito> ubigeoDistrito;
	

	public List<UbigeoDistrito> getUbigeoDistrito() {
		return ubigeoDistrito;
	}

	public void setUbigeoDistrito(List<UbigeoDistrito> ubigeoDistrito) {
		this.ubigeoDistrito = ubigeoDistrito;
	}

	public UbigeoDepartamento getUbigeoDepartamento() {
		return ubigeoDepartamento;
	}

	public void setUbigeoDepartamento(UbigeoDepartamento ubigeoDepartamento) {
		this.ubigeoDepartamento = ubigeoDepartamento;
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

	public int getUbigeoDepartamentoId() {
		return ubigeoDepartamentoId;
	}

	public void setUbigeoDepartamentoId(int ubigeoDepartamentoId) {
		this.ubigeoDepartamentoId = ubigeoDepartamentoId;
	}
	
}
