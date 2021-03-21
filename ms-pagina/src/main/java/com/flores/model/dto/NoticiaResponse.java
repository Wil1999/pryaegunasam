package com.flores.model.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class NoticiaResponse {
	
	private int id;
	private String titulo;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	
	private String autor;
	
	private boolean remove;

	
	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
