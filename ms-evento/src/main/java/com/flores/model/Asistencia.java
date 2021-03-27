package com.flores.model;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="asistencia",schema="evento")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_persona_evento")
	private int idPersonaEvento;
	
	@Column(name="flag_asiste")
	private boolean flagAsiste;
	
	@Column(name="usuario_id")
	private int usuarioId;
	
	@Column(name="id_inscripcion")
	private int idInscripcion;
	
	@Column(name="id_crono_evento")
	private int idCronoEvento;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_inscripcion",updatable = false, insertable = false)
	private Inscripcion inscripcion;
	
	@ManyToOne()
	@JsonManagedReference
	@JoinColumn(name="id_crono_evento", updatable = false, insertable = false)
	private CronogramaEvento cronogramaEvento;
	

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public CronogramaEvento getCronogramaEvento() {
		return cronogramaEvento;
	}

	public void setCronogramaEvento(CronogramaEvento cronogramaEvento) {
		this.cronogramaEvento = cronogramaEvento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPersonaEvento() {
		return idPersonaEvento;
	}

	public void setIdPersonaEvento(int idPersonaEvento) {
		this.idPersonaEvento = idPersonaEvento;
	}

	public boolean isFlagAsiste() {
		return flagAsiste;
	}

	public void setFlagAsiste(boolean flagAsiste) {
		this.flagAsiste = flagAsiste;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdCronoEvento() {
		return idCronoEvento;
	}

	public void setIdCronoEvento(int idCronoEvento) {
		this.idCronoEvento = idCronoEvento;
	}	

}
