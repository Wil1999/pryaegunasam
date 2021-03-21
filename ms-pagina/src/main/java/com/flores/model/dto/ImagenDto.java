package com.flores.model.dto;

import java.sql.Timestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class ImagenDto {
	
	private int noticiaId;
	
	private int eventoId;
	
	private int estado;
	
	private int personaId;
	
	private boolean remove;

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

}
