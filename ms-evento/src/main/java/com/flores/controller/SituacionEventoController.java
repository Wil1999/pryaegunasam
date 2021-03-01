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

import com.flores.model.SituacionEvento;
import com.flores.model.dto.SituacionEventoDto;
import com.flores.repository.SituacionEventoRepository;

@RestController
@RequestMapping("/situacionevento")
public class SituacionEventoController {
	
	@Autowired
	private SituacionEventoRepository situacionEventoRepository;

	@GetMapping("/listar")
	private List<SituacionEvento> show(){
		return situacionEventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<SituacionEvento> show(@PathVariable int id) {
		return situacionEventoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private SituacionEvento create(@RequestBody SituacionEventoDto situacionEvento) {
		SituacionEvento situacionEventoNow = new SituacionEvento();
		situacionEventoNow.setNombre(situacionEvento.getNombre());
		situacionEventoNow.setEstado(situacionEvento.isEstado());
		return situacionEventoRepository.save(situacionEventoNow);
	}
	
	@PutMapping(path ="/{id}")
	private SituacionEvento update(@RequestBody SituacionEventoDto situacionEvento,@PathVariable int id) {
		SituacionEvento situacionEventoNow = situacionEventoRepository.findById(id).orElse(null);
		situacionEventoNow.setNombre(situacionEvento.getNombre());
		situacionEventoNow.setEstado(situacionEvento.isEstado());
		
		return situacionEventoRepository.save(situacionEventoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		situacionEventoRepository.deleteById(id);
	}
}
