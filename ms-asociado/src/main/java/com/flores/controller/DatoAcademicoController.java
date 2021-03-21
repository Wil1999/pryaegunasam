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

import com.flores.model.DatoAcademico;
import com.flores.repository.DatoAcademicoRepository;

@RestController
@RequestMapping("/datoacademico")
public class DatoAcademicoController {

	@Autowired
	private DatoAcademicoRepository academicoRepository;
	
	@GetMapping("/listGrad/{id}")
	private Optional<List<DatoAcademico>> listbyGrado(@PathVariable int id){
		return academicoRepository.findAllByGradoAcadId(id);
	}
	
	@GetMapping("/listEsp/{id}")
	private Optional<List<DatoAcademico>> listbyEspecialidad(@PathVariable int id){
		return academicoRepository.findAllByEspecialidadId(id);
	}
	
	@GetMapping("/listPer/{id}")
	private Optional<List<DatoAcademico>> listbyPersona(@PathVariable int id){
		return academicoRepository.findAllByPersonaId(id);
	}
	
	@GetMapping("/listar")
	private List<DatoAcademico> show(){
		return academicoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<DatoAcademico> show(@PathVariable int id) {
		return academicoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private DatoAcademico create(@RequestBody DatoAcademico datoAcademico) {
		return academicoRepository.save(datoAcademico);
	}
	
	@PutMapping(path ="/{id}")
	private DatoAcademico update(@RequestBody DatoAcademico datoAcademico,@PathVariable int id) {
		DatoAcademico datoAcademicoNow = academicoRepository.findById(id).orElse(null);
		datoAcademicoNow.setGradoAcadId(datoAcademico.getGradoAcadId());
		datoAcademicoNow.setEspecialidadId(datoAcademico.getEspecialidadId());
		datoAcademicoNow.setFechaEmision(datoAcademico.getFechaEmision());
		datoAcademicoNow.setFechaTermino(datoAcademico.getFechaTermino());
		datoAcademicoNow.setRemove(datoAcademico.getRemove());
		datoAcademicoNow.setUsuarioId(datoAcademico.getUsuarioId());
		return academicoRepository.save(datoAcademicoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		academicoRepository.deleteById(id);
	}
}
