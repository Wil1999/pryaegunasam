package com.flores.feign.clients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flores.feign.models.Usuario;

@FeignClient(name = "msusuario", url="localhost:8014")
@RequestMapping("/usuario")
public interface UsuarioClienteRest {
	
	@GetMapping("/listar") 
	public List<Usuario> listar();
	
	@GetMapping(path = "/{id}")
	public Optional<Usuario> show(@PathVariable int id);
	
	@GetMapping(path ="/obtener/{idPersona}")
	public Optional<List<Usuario>> buscarPorId(@PathVariable int idPersona);

}
