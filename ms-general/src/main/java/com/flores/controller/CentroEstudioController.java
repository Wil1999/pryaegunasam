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

import com.flores.model.CentroEstudio;
import com.flores.model.dto.CentroEstudioDto;
import com.flores.repository.CentroEstudioRepository;

@RestController
@RequestMapping("/centroestudio")
public class CentroEstudioController {
	
	@Autowired
	private CentroEstudioRepository centroEstudioRepository;
	
	@GetMapping(path = "/listar")
	private List<CentroEstudio> listar() {
		return centroEstudioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<CentroEstudio> show(@PathVariable int id) {
		return centroEstudioRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private CentroEstudio create(@RequestBody CentroEstudioDto centroEstudio) {
		CentroEstudio centroEstudioNow = new CentroEstudio();
		centroEstudioNow.setDescripcion(centroEstudio.getDescripcion());
		centroEstudioNow.setFlagUnasam(centroEstudio.getFlagUnasam());
		return centroEstudioRepository.save(centroEstudioNow);
	}
	
	@PutMapping(path ="/{id}")
	private CentroEstudio update(@RequestBody CentroEstudioDto centroEstudio,@PathVariable int id) {
		CentroEstudio centroEstudioNow = centroEstudioRepository.findById(id).orElse(null);
		centroEstudioNow.setDescripcion(centroEstudio.getDescripcion());
		centroEstudioNow.setFlagUnasam(centroEstudio.getFlagUnasam());
		
		return centroEstudioRepository.save(centroEstudioNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		centroEstudioRepository.deleteById(id);
	}
}
