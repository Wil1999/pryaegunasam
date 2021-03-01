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

import com.flores.model.Institucion;
import com.flores.model.dto.InstitucionDto;
import com.flores.repository.InstitucionRepository;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {

	@Autowired
	private InstitucionRepository institucionRepository;
	
	@GetMapping(path = "/listar")
	private List<Institucion> listar() {
		return institucionRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Institucion> show(@PathVariable int id) {
		return institucionRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Institucion create(@RequestBody InstitucionDto institucion) {
		Institucion institucionNow = new Institucion();
		institucionNow.setRuc(institucion.getRuc());
		institucionNow.setDescripcion(institucion.getDescripcion());
		return institucionRepository.save(institucionNow);
	}
	
	@PutMapping(path ="/{id}")
	private Institucion update(@RequestBody InstitucionDto institucion,@PathVariable int id) {
		Institucion institucionNow = institucionRepository.findById(id).orElse(null);
		institucionNow.setRuc(institucion.getRuc());
		institucionNow.setDescripcion(institucion.getDescripcion());
		
		return institucionRepository.save(institucionNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		institucionRepository.deleteById(id);
	}
}
