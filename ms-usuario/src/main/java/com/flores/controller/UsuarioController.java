package com.flores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.Usuario;
import com.flores.model.dto.UsuarioDto;
import com.flores.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Resetear la contraseña FIXME Revisar
	@PutMapping(path= "/resetearContraseña/{id}")
	private ResponseEntity<String> resetearContraseña(@PathVariable int id, String contraseña){
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		usuario.setPass(contraseña);
		return new ResponseEntity<String>("CONTRASEÑA MODIFICADA CORRECTAMENTE", HttpStatus.ACCEPTED);
	}
	
	//Habilitar o deshabilitar un usuario
	@PutMapping(path ="/darBajaAlta/{id}")
	private ResponseEntity<String> darBajaAltaUsuario(@PathVariable int id, boolean bajaAlta){
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		usuario.setRemove(bajaAlta);
		if(bajaAlta) {
			return new ResponseEntity<String>("USUARIO DADO DE ALTA EXITOSAMENTE",HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<String>("USUARIO DADO DE BAJA EXITOSAMENTE",HttpStatus.ALREADY_REPORTED);
	}
	
	@GetMapping("/listar")
	private List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Usuario> show(@PathVariable int id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Usuario create(@RequestBody UsuarioDto usuario) {
		Usuario usuarioNow = new Usuario();
		usuarioNow.setUserName(usuario.getUserName());
		usuarioNow.setIdPersona(usuario.getIdPersona());
		usuarioNow.setPass(usuario.getPass());
		usuarioNow.setEstado(usuario.isEstado());
		usuarioNow.setRemove(usuario.isRemove());
		return usuarioRepository.save(usuarioNow);
	}
	
	@PutMapping(path ="/{id}")
	private Usuario update(@RequestBody UsuarioDto usuario,@PathVariable int id) {
		Usuario usuarioNow = usuarioRepository.findById(id).orElse(null);
		usuarioNow.setUserName(usuario.getUserName());
		usuarioNow.setIdPersona(usuario.getIdPersona());
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
