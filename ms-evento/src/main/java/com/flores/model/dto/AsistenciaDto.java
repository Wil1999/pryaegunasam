package com.flores.model.dto;

public class AsistenciaDto {
	
	private int id;
	
	private int idPersonaEvento;
	
	private boolean flagAsiste;
	
	private int usuarioId;
	
	private int idInscripcion;
	
	private int idCronoEvento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPersonaEvento() {
		return idPersonaEvento;
	}

	public void setIdPersonaEvento(int idPersonaEvento) {
		this.idPersonaEvento = idPersonaEvento;
	}

	public boolean isFlagAsiste() {
		return flagAsiste;
	}

	public void setFlagAsiste(boolean flagAsiste) {
		this.flagAsiste = flagAsiste;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdCronoEvento() {
		return idCronoEvento;
	}

	public void setIdCronoEvento(int idCronoEvento) {
		this.idCronoEvento = idCronoEvento;
	}
	
	
}
