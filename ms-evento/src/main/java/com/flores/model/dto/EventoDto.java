package com.flores.model.dto;

import java.sql.Timestamp;
import java.util.Date;


public class EventoDto {
	
	private int id;
	
	private String titulo;
	
	private String descripcion;
	
	private Date fechaInicio;
	
	private Date fechaTermino;
	
	private Date detalle;
	
	private boolean estado;
	
	private int costo;
	
	private int descuentoAsociado;
	
	private boolean remove;
	
	private int usuarioId;
	
	private int tipoEventoId;
	
	private int idSitEvento;
	
	private int idInstructor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Date getDetalle() {
		return detalle;
	}

	public void setDetalle(Date detalle) {
		this.detalle = detalle;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getDescuentoAsociado() {
		return descuentoAsociado;
	}

	public void setDescuentoAsociado(int descuentoAsociado) {
		this.descuentoAsociado = descuentoAsociado;
	}
	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}


	public int getTipoEventoId() {
		return tipoEventoId;
	}

	public void setTipoEventoId(int tipoEventoId) {
		this.tipoEventoId = tipoEventoId;
	}

	public int getIdSitEvento() {
		return idSitEvento;
	}

	public void setIdSitEvento(int idSitEvento) {
		this.idSitEvento = idSitEvento;
	}

	public int getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}
	
	
	
}
