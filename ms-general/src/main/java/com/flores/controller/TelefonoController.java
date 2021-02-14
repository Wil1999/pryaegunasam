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

import com.flores.model.Telefono;
import com.flores.repository.TelefonoRepository;

@RestController
@RequestMapping("/telefono")
public class TelefonoController {

	@Autowired
	private TelefonoRepository telefonoRepository;
	
	@GetMapping(path = "/listar")
	private List<Telefono> listar() {
		return telefonoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Telefono> show(@PathVariable int id) {
		return telefonoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Telefono create(@RequestBody Telefono telefono) {
		return telefonoRepository.save(telefono);
	}
	
	@PutMapping(path ="/{id}")
	private Telefono update(@RequestBody Telefono telefono,@PathVariable int id) {
		Telefono telefonoNow = telefonoRepository.findById(id).orElse(null);
		telefonoNow.setNumTelefono(telefono.getNumTelefono());
		telefonoNow.setTipoOperador(telefono.getTipoOperador());
		telefonoNow.setTipoTelefono(telefono.getTipoTelefono());
		telefonoNow.setPersona(telefono.getPersona());
		
		return telefonoRepository.save(telefonoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		telefonoRepository.deleteById(id);
	}
}
