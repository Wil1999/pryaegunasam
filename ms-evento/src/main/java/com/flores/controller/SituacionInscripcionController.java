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

import com.flores.model.SituacionInscripcion;
import com.flores.model.dto.SituacionInscripcionDto;
import com.flores.repository.SituacionInscripcionRepository;

@RestController
@RequestMapping("situacioninscripcion")
public class SituacionInscripcionController {

	@Autowired
	private SituacionInscripcionRepository situacionInscripcionRepository;
	
	@GetMapping("/listar")
	private List<SituacionInscripcion> show(){
		return situacionInscripcionRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<SituacionInscripcion> show(@PathVariable int id) {
		return situacionInscripcionRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private SituacionInscripcion create(@RequestBody SituacionInscripcionDto situacionInscripcion) {
		SituacionInscripcion situacionInscripcionNow = new SituacionInscripcion();
		situacionInscripcionNow.setNombre(situacionInscripcion.getNombre());
		situacionInscripcionNow.setEstado(situacionInscripcion.isEstado());
		return situacionInscripcionRepository.save(situacionInscripcionNow);
	}
	
	@PutMapping(path ="/{id}")
	private SituacionInscripcion update(@RequestBody SituacionInscripcionDto situacionInscripcion,@PathVariable int id) {
		SituacionInscripcion situacionInscripcionNow = situacionInscripcionRepository.findById(id).orElse(null);
		situacionInscripcionNow.setNombre(situacionInscripcion.getNombre());
		situacionInscripcionNow.setEstado(situacionInscripcion.isEstado());
		
		return situacionInscripcionRepository.save(situacionInscripcionNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		situacionInscripcionRepository.deleteById(id);
	}
}
