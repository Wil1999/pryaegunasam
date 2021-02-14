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
@Table(name="telefono", schema="general")
public class Telefono {
	
	public Telefono() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="num_telefono")
	private String numTelefono;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_tipo_operador")
	private TipoOperador tipoOperador;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_tipo_telefono")
	private TipoTelefono tipoTelefono;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_persona")
	private Persona persona;
	

	public TipoOperador getTipoOperador() {
		return tipoOperador;
	}

	public void setTipoOperador(TipoOperador tipoOperador) {
		this.tipoOperador = tipoOperador;
	}

	public TipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	
}
