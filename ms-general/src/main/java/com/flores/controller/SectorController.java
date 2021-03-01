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

import com.flores.model.Sector;
import com.flores.model.dto.SectorDto;
import com.flores.repository.SectorRepository;

@RestController
@RequestMapping("/sector")
public class SectorController {

	@Autowired
	private SectorRepository sectorRepository;
	
	@GetMapping(path = "/listar")
	private List<Sector> listar() {
		return sectorRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Sector> show(@PathVariable int id) {
		return sectorRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Sector create(@RequestBody SectorDto sector) {
		Sector sectorNow = new Sector();
		sectorNow.setDescripcion(sector.getDescripcion());
		return sectorRepository.save(sectorNow);
	}
	
	@PutMapping(path ="/{id}")
	private Sector update(@RequestBody SectorDto sector,@PathVariable int id) {
		Sector sectorNow = sectorRepository.findById(id).orElse(null);
		sectorNow.setDescripcion(sector.getDescripcion());
		
		return sectorRepository.save(sectorNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		sectorRepository.deleteById(id);
	}
}
