package com.flores.model.dto;

public class ConsejoDto {
	
	private int id;
	
	private int idPeriodo;
	
	private int cargoId;
	
	private String flagTipo;
	
	private int idAsociado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public String getFlagTipo() {
		return flagTipo;
	}

	public void setFlagTipo(String flagTipo) {
		this.flagTipo = flagTipo;
	}

	public int getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(int idAsociado) {
		this.idAsociado = idAsociado;
	}
}
