package com.flores.model.dto;


public class UbigeoDistritoDto {

	private int id;
	
	private String nombre;

	private int ubigeoProvinciaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUbigeoProvinciaId() {
		return ubigeoProvinciaId;
	}

	public void setUbigeoProvinciaId(int ubigeoProvinciaId) {
		this.ubigeoProvinciaId = ubigeoProvinciaId;
	}
}
