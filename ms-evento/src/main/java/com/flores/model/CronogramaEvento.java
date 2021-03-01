package com.flores.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cronograma_evento",schema="evento")
public class CronogramaEvento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date fecha;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	private boolean remove;
	
	private String descripcion;
	
	@Column(name="id_evento")
	private int idEvento;
	
	@Column(name="id_dia_semana")
	private int idDiaSemana;
	
	@JsonBackReference
	@OneToMany(mappedBy="cronogramaEvento")
	private List<Asistencia> asistencia;

	@ManyToOne()
	@JoinColumn(name="id_evento", insertable = false, updatable = false)
	private Evento evento;
	
	@ManyToOne()
	@JoinColumn(name="id_dia_semana", insertable = false, updatable = false)
	private DiaSemana diaSemana;
	

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public List<Asistencia> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(List<Asistencia> asistencia) {
		this.asistencia = asistencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdDiaSemana() {
		return idDiaSemana;
	}

	public void setIdDiaSemana(int idDiaSemana) {
		this.idDiaSemana = idDiaSemana;
	}
	
	
}
