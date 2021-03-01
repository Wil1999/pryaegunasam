package com.flores.model.dto;


public class UsuRolMenuDto {
	
	private int id;
	
	private boolean estado;
	
	private int idUsuarioRol;
	
	private int idMenu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
}
