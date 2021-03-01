package com.flores.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="consejo", schema="asociado")
public class Consejo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_periodo")
	private int idPeriodo;
	
	@Column(name="cargo_id")
	private int cargoId;
	
	@Column(name="flag_tipo")
	private String flagTipo;
	
	@Column(name="id_asociado")
	private int idAsociado;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_asociado",insertable = false, updatable = false)
	private Asociado asociado;
	

	public Asociado getAsociado() {
		return asociado;
	}

	public void setAsociado(Asociado asociado) {
		this.asociado = asociado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlagTipo() {
		return flagTipo;
	}

	public void setFlagTipo(String flagTipo) {
		this.flagTipo = flagTipo;
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

	public int getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(int idAsociado) {
		this.idAsociado = idAsociado;
	}

}
