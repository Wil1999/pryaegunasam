package com.flores.model;

import java.util.Date;
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
@Table(name="asociado",schema="asociado")
public class Asociado {
	
	public Asociado() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="persona_id")
	private int personaId;
	
	private int numero;
	
	@Column(name="fecha_incorporacion")
	private Date fechaIncorporacion;
	
	private boolean estado;
	
	private boolean remove;
	
	@Column(name="usuario_id")
	private int usuarioId;

	@JsonBackReference
	@OneToMany(mappedBy = "asociado")
	private List<Consejo> consejo;
	
	
	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public List<Consejo> getConsejo() {
		return consejo;
	}

	public void setConsejo(List<Consejo> consejo) {
		this.consejo = consejo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	
	
}
