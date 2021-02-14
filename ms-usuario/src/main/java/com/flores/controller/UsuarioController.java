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

import com.flores.model.Usuario;
import com.flores.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listar")
	private List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Usuario> show(@PathVariable int id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Usuario create(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping(path ="/{id}")
	private Usuario update(@RequestBody Usuario usuario,@PathVariable int id) {
		Usuario usuarioNow = usuarioRepository.findById(id).orElse(null);
		usuarioNow.setUserName(usuario.getUserName());
		usuarioNow.setPass(usuario.getPass());
		usuarioNow.setEstado(usuario.isEstado());
		usuarioNow.setRemove(usuario.isRemove());
		
		return usuarioRepository.save(usuarioNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		usuarioRepository.deleteById(id);
	}
	
	@GetMapping(path = "/obtener/{idPersona}")
	public Optional<List<Usuario>> buscarPorId(@PathVariable("idPersona") int idPersona) {
		return usuarioRepository.buscarPorId(idPersona);
	}
}
