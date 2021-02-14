package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.flores.feign.models.Consejo;

@Entity
@Table(name="periodo", schema="general")
public class Periodo {
	
	@Transient
	private List<Consejo> consejo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String anio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public List<Consejo> getConsejo() {
		return consejo;
	}

	public void setConsejo(List<Consejo> consejo) {
		this.consejo = consejo;
	}
	
}
