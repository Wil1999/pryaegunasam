
package com.flores.model;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="usuario_roles",schema="gestion_usuario")
public class UsuarioRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="id_roles")
	private int idRoles;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_usuario", insertable = false, updatable = false)
	private Usuario usuario;
	
	@JsonManagedReference
	@ManyToOne()
	@JoinColumn(name="id_roles", insertable = false, updatable = false)
	private Roles roles;
	
	@JsonBackReference
	@OneToMany(mappedBy = "usuarioRoles")
	private List<UsuRolMenu> usuRolMenu;
	

	public List<UsuRolMenu> getUsuRolMenu() {
		return usuRolMenu;
	}

	public void setUsuRolMenu(List<UsuRolMenu> usuRolMenu) {
		this.usuRolMenu = usuRolMenu;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}
	
	
}
