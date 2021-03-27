package com.flores.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="inscripcion", schema="evento")
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="persona_id")
	private int personaId;
	
	@Column(name="flag_entrega_certificado")
	private boolean flagEntregaCertificado;

	private boolean remove;
	
	private String nota;
	
	@Column(name="record_asistencia")
	private int recordAsistencia;
	
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Column(name="usuario_id")
	private int usuarioId;
	
	@Column(name="id_situacion_insc")
	private int idSituacionInsc;
	
	@Column(name="evento_id")
	private int eventoId;
	
	@JsonBackReference
	@OneToOne(mappedBy = "inscripcion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Asistencia asistencia;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_situacion_insc", insertable = false,updatable = false)
	private SituacionInscripcion situacionInscripcion;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="evento_id", insertable = false, updatable = false)
	private Evento evento;
	
	
	public Asistencia getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public SituacionInscripcion getSituacionInscripcion() {
		return situacionInscripcion;
	}

	public void setSituacionInscripcion(SituacionInscripcion situacionInscripcion) {
		this.situacionInscripcion = situacionInscripcion;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFlagEntregaCertificado() {
		return flagEntregaCertificado;
	}

	public void setFlagEntregaCertificado(boolean flagEntregaCertificado) {
		this.flagEntregaCertificado = flagEntregaCertificado;
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

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public int getIdSituacionInsc() {
		return idSituacionInsc;
	}

	public void setIdSituacionInsc(int idSituacionInsc) {
		this.idSituacionInsc = idSituacionInsc;
	}

	public int getEventoId() {
		return eventoId;
	}

	public void setEventoId(int eventoId) {
		this.eventoId = eventoId;
	}

	
}
