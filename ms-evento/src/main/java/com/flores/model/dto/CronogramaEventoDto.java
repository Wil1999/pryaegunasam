package com.flores.model.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CronogramaEventoDto {
	
	private int id;
	
	private Date fecha;
	
	@Temporal(TemporalType.DATE)
	private Timestamp createdAt;
	
	@Temporal(TemporalType.DATE)
	private Timestamp updatedAt;
	
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
