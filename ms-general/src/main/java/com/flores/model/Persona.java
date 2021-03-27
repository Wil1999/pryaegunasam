package com.flores.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.flores.feign.models.Asociado;
import com.flores.feign.models.DatoAcademico;
import com.flores.feign.models.DatoLaboral;
import com.flores.feign.models.Inscripcion;
import com.flores.feign.models.Instructor;
import com.flores.feign.models.Usuario;


@Entity
@Table(name="persona", schema="general")
public class Persona {

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String dni;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	private String nombre;
	
	private String direccion;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name="id_ubgdis_lugar_nac")
	private int ubigeoDistritoNacId;
	
	@Column(name="id_ubgdis_domicilio")
	private int ubigeoDistritoDomId;
	
	@ManyToOne()
	@JsonManagedReference
	@JoinColumn(name="id_ubgdis_lugar_nac", insertable = false, updatable= false)
	private UbigeoDistrito ubigeoDistritoNac;
	
	@ManyToOne()
	@JsonManagedReference
	@JoinColumn(name="id_ubgdis_domicilio", insertable = false, updatable = false)
	private UbigeoDistrito ubigeoDistritoDom;
	
	@JsonBackReference
	@OneToMany(mappedBy = "persona")
	private List<Telefono> telefono;
	
	@JsonBackReference
	@OneToMany(mappedBy = "persona")
	private List<Correo> correo;
	
	@Transient
	private List<Usuario> usuario;
	
	@Transient
	private List<DatoLaboral> datoLaboral;
	
	@Transient
	private List<DatoAcademico> datoAcademico;
	
	@Transient
	private List<Asociado> asociado;
	
	@Transient
	@JsonBackReference
	private List<Inscripcion> inscripcion;
	
	@Transient
	private List<Instructor> instructor;

	public List<Telefono> getTelefono() {
		return telefono;
	}

	public void setTelefono(List<Telefono> telefono) {
		this.telefono = telefono;
	}

	public List<Correo> getCorreo() {
		return correo;
	}

	public void setCorreo(List<Correo> correo) {
		this.correo = correo;
	}

	public UbigeoDistrito getUbigeoDistritoNac() {
		return ubigeoDistritoNac;
	}

	public void setUbigeoDistritoNac(UbigeoDistrito ubigeoDistritoNac) {
		this.ubigeoDistritoNac = ubigeoDistritoNac;
	}

	public UbigeoDistrito getUbigeoDistritoDom() {
		return ubigeoDistritoDom;
	}

	public void setUbigeoDistritoDom(UbigeoDistrito ubigeoDistritoDom) {
		this.ubigeoDistritoDom = ubigeoDistritoDom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Asociado> getAsociado() {
		return asociado;
	}

	public void setAsociado(List<Asociado> asociado) {
		this.asociado = asociado;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<DatoLaboral> getDatoLaboral() {
		return datoLaboral;
	}

	public void setDatoLaboral(List<DatoLaboral> datoLaboral) {
		this.datoLaboral = datoLaboral;
	}

	public List<DatoAcademico> getDatoAcademico() {
		return datoAcademico;
	}

	public void setDatoAcademico(List<DatoAcademico> datoAcademico) {
		this.datoAcademico = datoAcademico;
	}

	public List<Inscripcion> getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(List<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}

	public List<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}

	public int getUbigeoDistritoNacId() {
		return ubigeoDistritoNacId;
	}

	public void setUbigeoDistritoNacId(int ubigeoDistritoNacId) {
		this.ubigeoDistritoNacId = ubigeoDistritoNacId;
	}

	public int getUbigeoDistritoDomId() {
		return ubigeoDistritoDomId;
	}

	public void setUbigeoDistritoDomId(int ubigeoDistritoDomId) {
		this.ubigeoDistritoDomId = ubigeoDistritoDomId;
	}
	
}
