package com.flores.model.dto;

import java.sql.Timestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class ImagenDto {
	
	private int id;
	
	private String url;
	
	private int noticiaId;
	
	private int eventoId;
	
	@Temporal(TemporalType.DATE)
	private Timestamp createdAt;
	
	@Temporal(TemporalType.DATE)
	private Timestamp updatedAt;
	
	private int estado;
	
	private int personaId;
	
	private boolean remove;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(int noticiaId) {
		this.noticiaId = noticiaId;
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
