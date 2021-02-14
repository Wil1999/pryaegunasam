
package com.flores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario_roles",schema="gestion_usuario")
public class UsuarioRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name="id_roles")
	private Roles roles;
	
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
	
	
}
