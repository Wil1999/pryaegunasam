package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.flores.feign.models.DatoAcademico;

@Entity
@Table(name="grado_academico",schema="general")
public class GradoAcademico {
	
	@Transient
	private List<DatoAcademico> datoAcademico;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descripcion;

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
	
}
