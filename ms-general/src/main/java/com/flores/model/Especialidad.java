package com.flores.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.flores.feign.models.DatoAcademico;

@Entity
@Table(name="especialidad",schema="general")
public class Especialidad {
	
	@Transient
	private List<DatoAcademico> datoAcademico;
	
	public Especialidad() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descripcion;
	
	@Column(name="centro_estudio_id")
	private int centroEstudioId;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="centro_estudio_id", insertable = false, updatable = false)
	private CentroEstudio centroEstudio;

	
	public CentroEstudio getCentroEstudio() {
		return centroEstudio;
	}

	public void setCentroEstudio(CentroEstudio centroEstudio) {
		this.centroEstudio = centroEstudio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DatoAcademico> getDatoAcademico() {
		return datoAcademico;
	}

	public void setDatoAcademico(List<DatoAcademico> datoAcademico) {
		this.datoAcademico = datoAcademico;
	}

	public int getCentroEstudioId() {
		return centroEstudioId;
	}

	public void setCentroEstudioId(int centroEstudioId) {
		this.centroEstudioId = centroEstudioId;
	}

}
