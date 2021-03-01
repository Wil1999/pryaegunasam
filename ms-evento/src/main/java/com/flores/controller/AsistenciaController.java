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

import com.flores.model.Asistencia;
import com.flores.model.dto.AsistenciaDto;
import com.flores.repository.AsistenciaRepository;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@GetMapping("/listar")
	private List<Asistencia> show(){
		return asistenciaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Asistencia> show(@PathVariable int id) {
		return asistenciaRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Asistencia create(@RequestBody AsistenciaDto asistencia) {
		Asistencia asistenciaNow = new Asistencia();
		asistenciaNow.setIdPersonaEvento(asistencia.getIdPersonaEvento());
		asistenciaNow.setIdCronoEvento(asistencia.getIdCronoEvento());
		asistenciaNow.setFlagAsiste(asistencia.isFlagAsiste());
		asistenciaNow.setUsuarioId(asistencia.getUsuarioId());
		asistenciaNow.setIdInscripcion(asistencia.getIdInscripcion());
		return asistenciaRepository.save(asistenciaNow);
	}
	
	@PutMapping(path ="/{id}")
	private Asistencia update(@RequestBody AsistenciaDto asistencia,@PathVariable int id) {
		Asistencia asistenciaNow = asistenciaRepository.findById(id).orElse(null);
		asistenciaNow.setIdPersonaEvento(asistencia.getIdPersonaEvento());
		asistenciaNow.setIdCronoEvento(asistencia.getIdCronoEvento());
		asistenciaNow.setFlagAsiste(asistencia.isFlagAsiste());
		asistenciaNow.setUsuarioId(asistencia.getUsuarioId());
		asistenciaNow.setIdInscripcion(asistencia.getIdInscripcion());
		
		return asistenciaRepository.save(asistenciaNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		asistenciaRepository.deleteById(id);
	}
}
