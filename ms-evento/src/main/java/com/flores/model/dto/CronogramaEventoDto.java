package com.flores.model.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.flores.model.CronogramaEvento;

public class CronogramaEventoDto {

	
	
	public CronogramaEventoDto(int id, Date fecha, boolean remove,
			String descripcion, int idEvento, int idDiaSemana) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.remove = remove;
		this.descripcion = descripcion;
		this.idEvento = idEvento;
		this.idDiaSemana = idDiaSemana;
	}

	private int id;
	
	private Date fecha;
	
	private boolean remove;
	
	private String descripcion;
	
	private int idEvento;
	
	private int idDiaSemana;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdDiaSemana() {
		return idDiaSemana;
	}

	public void setIdDiaSemana(int idDiaSemana) {
		this.idDiaSemana = idDiaSemana;
	}
	
}
