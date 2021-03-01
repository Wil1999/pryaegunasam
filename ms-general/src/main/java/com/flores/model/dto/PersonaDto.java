package com.flores.model.dto;

import java.util.Date;

public class PersonaDto {
	
	private int id;
	
	private String dni;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String nombre;
	
	private String direccion;
	
	private Date fechaNacimiento;
	
	private int ubigeoDistritoNacId;
	
	private int ubigeoDistritoDomId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getUbigeoDistritoNacId() {
		return ubigeoDistritoNacId;
	}

	public void setUbigeoDistritoNacId(int ubigeoDistritoNacId) {
		this.ubigeoDistritoNacId = ubigeoDistritoNacId;
	}

	public int getUbigeoDistritoDomId() {
		return ubigeoDistritoDomId;
	}

	public void setUbigeoDistritoDomId(int ubigeoDistritoDomId) {
		this.ubigeoDistritoDomId = ubigeoDistritoDomId;
	}
	
	
}
