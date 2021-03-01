package com.flores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.UsuarioRoles;
import com.flores.model.dto.UsuarioRolesDto;
import com.flores.repository.UsuarioRolesRepository;

@RestController
@RequestMapping("/usuarioroles")
public class UsuarioRolesController {

	@Autowired
	private UsuarioRolesRepository usuarioRolesRepository;
	
	@GetMapping("/listar")
	private List<UsuarioRoles> show(){
		return usuarioRolesRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<UsuarioRoles> show(@PathVariable int id) {
		return usuarioRolesRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private UsuarioRoles create(@RequestBody UsuarioRolesDto usuarioRoles) {
		UsuarioRoles usuarioRolesNow = new UsuarioRoles();
		usuarioRolesNow.setIdRoles(usuarioRoles.getIdRoles());
		usuarioRolesNow.setIdUsuario(usuarioRoles.getIdUsuario());
		return usuarioRolesRepository.save(usuarioRolesNow);
	}
	
	@PutMapping(path ="/{id}")
	private UsuarioRoles update(@RequestBody UsuarioRolesDto usuarioRoles,@PathVariable int id) {
		UsuarioRoles usuarioRolesNow = usuarioRolesRepository.findById(id).orElse(null);
		usuarioRolesNow.setIdRoles(usuarioRoles.getIdRoles());
		usuarioRolesNow.setIdUsuario(usuarioRoles.getIdUsuario());
		
		return usuarioRolesRepository.save(usuarioRolesNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		usuarioRolesRepository.deleteById(id);
	}
}
