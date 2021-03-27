package com.flores.model.dto;

public class UsuarioResponse {
	public UsuarioResponse(int id, String nombres, String usuario, String estado) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.usuario = usuario;
		this.estado = estado;
	}
	private int id;
	private String nombres;
	private String usuario;
	private String estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}
