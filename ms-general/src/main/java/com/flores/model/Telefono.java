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
	
	@Column(name="id_tipo_operador")
	private int tipoOperadorId;
	
	@Column(name="id_tipo_telefono")
	private int tipoTelefonoId;
	
	@Column(name="id_persona")
	private int idPersona;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_tipo_operador", insertable = false, updatable = false)
	private TipoOperador tipoOperador;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_tipo_telefono", insertable = false, updatable = false)
	private TipoTelefono tipoTelefono;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_persona", insertable = false, updatable = false)
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

	public int getTipoOperadorId() {
		return tipoOperadorId;
	}

	public void setTipoOperadorId(int tipoOperadorId) {
		this.tipoOperadorId = tipoOperadorId;
	}

	public int getTipoTelefonoId() {
		return tipoTelefonoId;
	}

	public void setTipoTelefonoId(int tipoTelefonoId) {
		this.tipoTelefonoId = tipoTelefonoId;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	
}
