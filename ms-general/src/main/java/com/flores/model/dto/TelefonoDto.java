package com.flores.model.dto;

public class TelefonoDto {

	private int id;
	
	private String numTelefono;
	
	private int tipoOperadorId;
	
	private int tipoTelefonoId;
	
	private int idPersona;

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
