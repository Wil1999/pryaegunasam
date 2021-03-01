package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="dia_semana", schema="evento")
public class DiaSemana {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descripcion;
	
	@JsonBackReference
	@OneToMany(mappedBy = "diaSemana")
	private List<CronogramaEvento> cronogramaEvento;

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

	public List<CronogramaEvento> getCronogramaEvento() {
		return cronogramaEvento;
	}

	public void setCronogramaEvento(List<CronogramaEvento> cronogramaEvento) {
		this.cronogramaEvento = cronogramaEvento;
	}
	
}
