package com.flores.feign.models;

public class Consejo {
	
	private int id;
	private int idPeriodo;
	private int IdAsociado;
	private int cargoId;
	private String flagTipo;
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
	public int getIdAsociado() {
		return IdAsociado;
	}
	public void setIdAsociado(int idAsociado) {
		IdAsociado = idAsociado;
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
	
}
