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
import javax.persistence.Transient;

import com.flores.feign.models.Imagen;

@Entity
@Table(name="evento", schema="evento")
public class Evento {
	
	@Transient
	private List<Imagen> imagen;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titulo;
	
	private String descripcion;
	
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@Column(name="fecha_termino")
	private Date fechaTermino;
	
	private Date detalle;
	
	private boolean estado;
	
	private int costo;
	
	@Column(name="descuento_asociado")
	private int descuentoAsociado;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	private boolean remove;
	
	@Column(name="usuario_id")
	private int usuarioId;
	
	@OneToMany(mappedBy = "evento")
	private List<Inscripcion> inscripcion;
	
	@ManyToOne()
	@JoinColumn(name="id_crono_evento")
	private CronogramaEvento cronogramaEvento;
	
	@ManyToOne()
	@JoinColumn(name="tipo_evento_id")
	private TipoEvento tipoEvento;
	
	@ManyToOne()
	@JoinColumn(name="id_sit_evento")
	private SituacionEvento situacionEvento;
	
	@ManyToOne()
	@JoinColumn(name="id_instructor")
	private Instructor instructor;

	public List<Inscripcion> getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(List<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}

	public CronogramaEvento getCronogramaEvento() {
		return cronogramaEvento;
	}

	public void setCronogramaEvento(CronogramaEvento cronogramaEvento) {
		this.cronogramaEvento = cronogramaEvento;
	}

	public SituacionEvento getSituacionEvento() {
		return situacionEvento;
	}

	public void setSituacionEvento(SituacionEvento situacionEvento) {
		this.situacionEvento = situacionEvento;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Date getDetalle() {
		return detalle;
	}

	public void setDetalle(Date detalle) {
		this.detalle = detalle;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getDescuentoAsociado() {
		return descuentoAsociado;
	}

	public void setDescuentoAsociado(int descuentoAsociado) {
		this.descuentoAsociado = descuentoAsociado;
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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<Imagen> getImagen() {
		return imagen;
	}

	public void setImagen(List<Imagen> imagen) {
		this.imagen = imagen;
	}
}
