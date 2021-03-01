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

import com.flores.feign.clients.DatoAcademicoClientRest;
import com.flores.feign.models.DatoAcademico;
import com.flores.model.Especialidad;
import com.flores.model.dto.EspecialidadDto;
import com.flores.repository.EspecialidadRepository;

@RestController
@RequestMapping("especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Autowired
	private DatoAcademicoClientRest datoClientRest;
	
	@GetMapping(path = "/listar")
	private List<Especialidad> listar() {
		List<Especialidad> especialidades =  especialidadRepository.findAll();
		for (Especialidad e : especialidades) {
			List<DatoAcademico> dato = datoClientRest.listbyEspecialidad(e.getId()).orElse(null);
			e.setDatoAcademico(dato);
		}
		return especialidades;
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Especialidad> show(@PathVariable int id) {
		return especialidadRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Especialidad create(@RequestBody EspecialidadDto especialidad) {
		Especialidad especialidadNow = new Especialidad();
		especialidadNow.setDescripcion(especialidad.getDescripcion());
		especialidadNow.setCentroEstudioId(especialidad.getCentroEstudioId());
		return especialidadRepository.save(especialidadNow);
	}
	
	@PutMapping(path ="/{id}")
	private Especialidad update(@RequestBody EspecialidadDto especialidad,@PathVariable int id) {
		Especialidad especialidadNow = especialidadRepository.findById(id).orElse(null);
		especialidadNow.setDescripcion(especialidad.getDescripcion());
		especialidadNow.setCentroEstudioId(especialidad.getCentroEstudioId());
		
		return especialidadRepository.save(especialidadNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		especialidadRepository.deleteById(id);
	}
}
