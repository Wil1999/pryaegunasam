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

import com.flores.model.DatoLaboral;
import com.flores.repository.DatoLaboralRepository;

@RestController
@RequestMapping("datolaboral")
public class DatoLaboralController {

	@Autowired
	private DatoLaboralRepository datoLaboralRepository;
	
	@GetMapping("/listTL/{id}")
	private Optional<List<DatoLaboral>> listTL(@PathVariable int id){
		return datoLaboralRepository.findAllByTipoLaboralId(id);
	}
	
	@GetMapping("/listSec/{id}")
	private Optional<List<DatoLaboral>> listSec(@PathVariable int id){
		return datoLaboralRepository.findAllBySectorId(id);
	}
	
	@GetMapping("/listInst/{id}")
	private Optional<List<DatoLaboral>> listInst(@PathVariable int id){
		return datoLaboralRepository.findAllByInstitucionId(id);
	}
	
	@GetMapping("/listPer/{id}")
	private Optional<List<DatoLaboral>> listPer(@PathVariable int id){
		return datoLaboralRepository.findAllByPersonaId(id);
	}
	
	@GetMapping("/listar")
	private List<DatoLaboral> show(){
		return datoLaboralRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<DatoLaboral> show(@PathVariable int id) {
		return datoLaboralRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private DatoLaboral create(@RequestBody DatoLaboral datoLaboral) {
		return datoLaboralRepository.save(datoLaboral);
	}
	
	@PutMapping(path ="/{id}")
	private DatoLaboral update(@RequestBody DatoLaboral datoLaboral,@PathVariable int id) {
		DatoLaboral datoLaboralNow = datoLaboralRepository.findById(id).orElse(null);
		datoLaboralNow.setInstitucionId(datoLaboral.getInstitucionId());
		datoLaboralNow.setSectorId(datoLaboral.getSectorId());
		datoLaboralNow.setTipoLaboralId(datoLaboral.getTipoLaboralId());
		datoLaboralNow.setPersonaId(datoLaboral.getPersonaId());
		datoLaboralNow.setCargo(datoLaboral.getCargo());
		datoLaboralNow.setEstado(datoLaboral.getEstado());
		datoLaboralNow.setRemove(datoLaboral.getRemove());
		datoLaboralNow.setUsuarioId(datoLaboral.getUsuarioId());
		
		return datoLaboralRepository.save(datoLaboralNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		datoLaboralRepository.deleteById(id);
	}
	
	
}
