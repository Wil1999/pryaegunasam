package com.flores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dato_laboral", schema = "asociado")
public class DatoLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "institucion_id")
	private int institucionId;
	
	private String cargo;
	
	@Column(name="sector_id")
	private int sectorId;
	
	@Column(name="tipo_laboral_id")
	private int tipoLaboralId;
	
	@Column(name="persona_id")
	private int personaId;
	
	private String estado;
	
	private boolean remove;
	
	@Column(name="usuario_id")
	private int usuarioId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean getRemove() {
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

	public int getInstitucionId() {
		return institucionId;
	}

	public void setInstitucionId(int institucionId) {
		this.institucionId = institucionId;
	}

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public int getTipoLaboralId() {
		return tipoLaboralId;
	}

	public void setTipoLaboralId(int tipoLaboralId) {
		this.tipoLaboralId = tipoLaboralId;
	}
	
}
