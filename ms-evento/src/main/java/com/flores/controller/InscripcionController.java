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

import com.flores.model.Inscripcion;
import com.flores.repository.InscripcionRepository;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	
	@GetMapping("/listByPersona/{id}")
	private Optional<List<Inscripcion>> listByPersona(@PathVariable int id){
		return inscripcionRepository.findAllByPersonaId(id);
	}
	
	@GetMapping("/listar")
	private List<Inscripcion> show(){
		return inscripcionRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Inscripcion> show(@PathVariable int id) {
		return inscripcionRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Inscripcion create(@RequestBody Inscripcion inscripcion) {
		return inscripcionRepository.save(inscripcion);
	}
	
	@PutMapping(path ="/{id}")
	private Inscripcion update(@RequestBody Inscripcion inscripcion,@PathVariable int id) {
		Inscripcion inscripcionNow = inscripcionRepository.findById(id).orElse(null);
		inscripcionNow.setFlagEntregaCertificado(inscripcion.isFlagEntregaCertificado());
		inscripcionNow.setEvento(inscripcion.getEvento());
		inscripcionNow.setRemove(inscripcion.isRemove());
		inscripcionNow.setNota(inscripcion.getNota());
		inscripcionNow.setRecordAsistencia(inscripcion.getRecordAsistencia());
		inscripcionNow.setFechaRegistro(inscripcion.getFechaRegistro());
		inscripcionNow.setUsuarioId(inscripcion.getUsuarioId());		
		return inscripcionRepository.save(inscripcionNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		inscripcionRepository.deleteById(id);
	}
}
