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

import com.flores.model.Correo;
import com.flores.model.dto.CorreoDto;
import com.flores.repository.CorreoRepository;

@RestController
@RequestMapping("/correo")
public class CorreoController {
	
	@Autowired
	private CorreoRepository correoRepository;
	
	@GetMapping(path = "/listar")
	private List<Correo> listar() {
		return correoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Correo> show(@PathVariable int id) {
		return correoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Correo create(@RequestBody CorreoDto correo) {
		Correo correoNow = new Correo();
		correoNow.setUsuarioId(correo.getUsuarioId());
		correoNow.setPersonaId(correo.getPersonaId());
		correoNow.setTipoCorreoId(correo.getTipoCorreoId());
		return correoRepository.save(correoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Correo update(@RequestBody CorreoDto correo,@PathVariable int id) {
		Correo correoNow = correoRepository.findById(id).orElse(null);
		correoNow.setUsuarioId(correo.getUsuarioId());
		correoNow.setPersonaId(correo.getPersonaId());
		correoNow.setTipoCorreoId(correo.getTipoCorreoId());
		
		return correoRepository.save(correoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		correoRepository.deleteById(id);
	}
}
