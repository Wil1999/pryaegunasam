package com.flores.model.dto;

public class BannerResponse {
	private String titulo;
	private String descripcion;
	private String url;
	private int usuarioId;
	private int estado;
	private boolean remove;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public boolean isRemove() {
		return remove;
	}
	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
}
