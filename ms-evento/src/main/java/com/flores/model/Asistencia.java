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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_inscripcion")
	private Inscripcion inscripcion;
	
	@ManyToOne()
	@JoinColumn(name="id_crono_evento")
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
	
	

}
