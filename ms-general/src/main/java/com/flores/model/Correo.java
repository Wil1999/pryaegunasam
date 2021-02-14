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
@Table(name="correo",schema="general")
public class Correo {
	
	public Correo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="usuario_id")
	private int usuarioId;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_tipo_correo")
	private TipoCorreo tipoCorreo;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_persona")
	private Persona persona;

	public TipoCorreo getTipoCorreo() {
		return tipoCorreo;
	}

	public void setTipoCorreo(TipoCorreo tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
