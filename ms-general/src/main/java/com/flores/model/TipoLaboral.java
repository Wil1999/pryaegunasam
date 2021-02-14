package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.flores.feign.models.DatoLaboral;

@Entity
@Table(name="tipo_laboral",schema="general")
public class TipoLaboral {
	
	@Transient
	private List<DatoLaboral> datoLaboral;
	
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

	public List<DatoLaboral> getDatoLaboral() {
		return datoLaboral;
	}

	public void setDatoLaboral(List<DatoLaboral> datoLaboral) {
		this.datoLaboral = datoLaboral;
	}
	

}
