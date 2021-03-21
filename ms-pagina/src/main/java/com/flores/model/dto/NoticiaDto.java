package com.flores.model.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class NoticiaDto {
	private int id;
	
	private String titulo;
	
	private String descripcion;
	
	private boolean estado;
	
	private Date fechaPublicacion;
	
	private int idAutor;
	
	@Temporal(TemporalType.DATE)
	private Timestamp createdAt;
	
	@Temporal(TemporalType.DATE)
	private Timestamp updatedAt;
	
	private int usuarioId;
	
	private boolean remove;

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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	
}
