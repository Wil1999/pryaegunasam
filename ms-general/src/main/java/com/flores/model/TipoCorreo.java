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

@Entity
@Table(name = "tipo_correo", schema = "general")
public class TipoCorreo {
	
	public TipoCorreo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipo;
	
	@JsonBackReference
	@OneToMany(mappedBy = "tipoCorreo")
	private List<Correo> Correo;

	public List<Correo> getCorreo() {
		return Correo;
	}

	public void setCorreo(List<Correo> correo) {
		Correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
