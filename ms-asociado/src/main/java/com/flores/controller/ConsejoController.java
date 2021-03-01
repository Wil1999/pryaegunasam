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

import com.flores.model.Consejo;
import com.flores.model.DatoAcademico;
import com.flores.model.dto.ConsejoDto;
import com.flores.repository.ConsejoRepository;

@RestController
@RequestMapping("/consejo")
public class ConsejoController {
	
	@Autowired
	private ConsejoRepository consejoRepository;
	
	@GetMapping("/listPeriod/{id}")
	private Optional<List<Consejo>> listbyPeriodo(@PathVariable int id){
		return consejoRepository.findAllByIdPeriodo(id);
	}
	
	@GetMapping("/listCar/{id}")
	private Optional<List<Consejo>> listbyCargo(@PathVariable int id){
		return consejoRepository.findAllByCargoId(id);
	}

	@GetMapping("/listar")
	private List<Consejo> show(){
		return consejoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Consejo> show(@PathVariable int id) {
		return consejoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Consejo create(@RequestBody ConsejoDto consejo) {
		Consejo consejoNow = new Consejo();
		consejoNow.setIdPeriodo(consejo.getIdPeriodo());
		consejoNow.setCargoId(consejo.getCargoId());
		consejoNow.setFlagTipo(consejo.getFlagTipo());
		consejoNow.setIdAsociado(consejo.getIdAsociado());
		return consejoRepository.save(consejoNow);
	}
	
	@PutMapping(path ="/{id}")
	private Consejo update(@RequestBody ConsejoDto consejo,@PathVariable int id) {
		Consejo consejoNow = consejoRepository.findById(id).orElse(null);
		consejoNow.setFlagTipo(consejo.getFlagTipo());
		consejoNow.setCargoId(consejo.getCargoId());
		consejoNow.setIdAsociado(consejo.getIdAsociado());
		consejoNow.setIdPeriodo(consejo.getIdPeriodo());
		
		return consejoRepository.save(consejoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		consejoRepository.deleteById(id);
	}
}
