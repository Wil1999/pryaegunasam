package com.flores.model.dto;


public class EspecialidadDto {
	
	private int id;
	
	private String descripcion;

	private int centroEstudioId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCentroEstudioId() {
		return centroEstudioId;
	}

	public void setCentroEstudioId(int centroEstudioId) {
		this.centroEstudioId = centroEstudioId;
	}

}
