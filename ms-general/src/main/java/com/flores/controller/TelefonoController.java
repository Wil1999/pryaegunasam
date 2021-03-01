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
import com.flores.model.dto.TelefonoDto;
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
	private Telefono create(@RequestBody TelefonoDto telefono) {
		Telefono telefonoNow = new Telefono();
		telefonoNow.setNumTelefono(telefono.getNumTelefono());
		telefonoNow.setTipoOperadorId(telefono.getTipoOperadorId());
		telefonoNow.setTipoTelefonoId(telefono.getTipoTelefonoId());
		telefonoNow.setIdPersona(telefono.getIdPersona());
		return telefonoRepository.save(telefonoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Telefono update(@RequestBody TelefonoDto telefono,@PathVariable int id) {
		Telefono telefonoNow = telefonoRepository.findById(id).orElse(null);
		telefonoNow.setNumTelefono(telefono.getNumTelefono());
		telefonoNow.setTipoOperadorId(telefono.getTipoOperadorId());
		telefonoNow.setTipoTelefonoId(telefono.getTipoTelefonoId());
		telefonoNow.setIdPersona(telefono.getIdPersona());
		
		return telefonoRepository.save(telefonoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		telefonoRepository.deleteById(id);
	}
}
