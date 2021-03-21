package com.flores.model.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AsociadoDto {
	
	private int id;
	
	private int personaId;
	
	private int numero;
	
	
	private boolean estado;
	
	private boolean remove;
	
	private int usuarioId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
