package com.flores.feign.models;

import java.util.Date;

public class Inscripcion {
	
	private int id;
	private int personaId;
	private boolean flagEntregaCertificado;
	private int eventoId;
	private boolean remove;
	private String nota;
	private int recordAsistencia;
	private Date fechaRegistro;
	private int usuarioId;
	private int idSituacionInsc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public boolean isFlagEntregaCertificado() {
		return flagEntregaCertificado;
	}
	public void setFlagEntregaCertificado(boolean flagEntregaCertificado) {
		this.flagEntregaCertificado = flagEntregaCertificado;
	}
	public int getEventoId() {
		return eventoId;
	}
	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}
	public boolean isRemove() {
		return remove;
	}
	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public int getRecordAsistencia() {
		return recordAsistencia;
	}
	public void setRecordAsistencia(int recordAsistencia) {
		this.recordAsistencia = recordAsistencia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getIdSituacionInsc() {
		return idSituacionInsc;
	}
	public void setIdSituacionInsc(int idSituacionInsc) {
		this.idSituacionInsc = idSituacionInsc;
	}
	
}
