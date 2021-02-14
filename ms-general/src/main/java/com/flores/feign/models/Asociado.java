package com.flores.feign.models;

import java.util.Date;

public class Asociado {
	
	private int id;
	private int personaId;
	private int numero;
	private Date fechasIncorporacion;
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
	public Date getFechasIncorporacion() {
		return fechasIncorporacion;
	}
	public void setFechasIncorporacion(Date fechasIncorporacion) {
		this.fechasIncorporacion = fechasIncorporacion;
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
