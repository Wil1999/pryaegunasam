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

import com.flores.feign.clients.ConsejoClientRest;
import com.flores.feign.models.Consejo;
import com.flores.model.Cargo;
import com.flores.model.dto.CargoDto;
import com.flores.repository.CargoRepository;

@RestController
@RequestMapping(path = "/cargo")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private ConsejoClientRest consejoClientRest;
	
	@GetMapping(path = "/listar")
	private List<Cargo> listar() {
		List<Cargo> cargos =  cargoRepository.findAll();
		for(Cargo c: cargos){
			List<Consejo> consejo = consejoClientRest.listbyCargo(c.getId()).orElse(null);
			c.setConsejo(consejo);
		}
		return cargos;
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Cargo> show(@PathVariable int id) {
		return cargoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Cargo create(@RequestBody CargoDto cargo) {
		Cargo cargoNow = new Cargo();
		cargoNow.setDescripcion(cargo.getDescripcion());
		return cargoRepository.save(cargoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Cargo update(@RequestBody CargoDto cargo,@PathVariable int id) {
		Cargo cargoNow = cargoRepository.findById(id).orElse(null);
		cargoNow.setDescripcion(cargo.getDescripcion());
		
		return cargoRepository.save(cargoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		cargoRepository.deleteById(id);
	}
	
	
}
