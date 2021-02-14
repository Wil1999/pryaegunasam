package com.flores.feign.models;

import java.util.Date;

public class DatoAcademico {
	
	private int id;
	private int gradoAcadId;
	private int especialidadId;
	private Date fechaEmision;
	private Date fechaIngreso;
	private Date fechaTermino;
	private int personaId;
	private boolean remove;
	private int usuarioId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGradoAcadId() {
		return gradoAcadId;
	}
	public void setGradoAcadId(int gradoAcadId) {
		this.gradoAcadId = gradoAcadId;
	}
	public int getEspecialidadId() {
		return especialidadId;
	}
	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
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
	
	

}
