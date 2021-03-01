package com.flores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flores.model.DiaSemana;
import com.flores.model.dto.DiaSemanaDto;
import com.flores.repository.DiaSemanaRepository;

@RestController
@RequestMapping(path = "/diasemana")
public class DiaSemanaController {
	
	@Autowired
	private DiaSemanaRepository diaSemanaRepository;
	
	@GetMapping("/listar")
	private List<DiaSemana> Listar(){
		return diaSemanaRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	private DiaSemana show(@PathVariable int id){
		return diaSemanaRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/nuevo")
	private DiaSemana Create(DiaSemanaDto diaSemana) {
		DiaSemana diaSemanaNow = new DiaSemana();
		diaSemanaNow.setDescripcion(diaSemana.getDescripcion());
		return diaSemanaRepository.save(diaSemanaNow);
	}
	
	@PutMapping("/{id}")
	private DiaSemana Update(DiaSemanaDto diaSemana, @PathVariable int id) {
		DiaSemana diaSemanaNow = diaSemanaRepository.findById(id).orElse(null);
		diaSemanaNow.setDescripcion(diaSemana.getDescripcion());
		return diaSemanaRepository.save(diaSemanaNow);
	}
	
	@DeleteMapping("/id")
	private void Delete(@PathVariable int id) {
		diaSemanaRepository.deleteById(id);
	}
	
	
}
