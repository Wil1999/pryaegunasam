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

import com.flores.model.CronogramaEvento;
import com.flores.repository.CronogramaEventoRepository;

@RestController
@RequestMapping("/cronogramaevento")
public class CronogramaEventoController {

	@Autowired
	private CronogramaEventoRepository cronogramaEventoRepository;
	
	@GetMapping("/listar")
	private List<CronogramaEvento> show(){
		return cronogramaEventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<CronogramaEvento> show(@PathVariable int id) {
		return cronogramaEventoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private CronogramaEvento create(@RequestBody CronogramaEvento cronogramaEvento) {
		return cronogramaEventoRepository.save(cronogramaEvento);
	}
	
	@PutMapping(path ="/{id}")
	private CronogramaEvento update(@RequestBody CronogramaEvento cronogramaEvento,@PathVariable int id) {
		CronogramaEvento cronogramaEventoNow = cronogramaEventoRepository.findById(id).orElse(null);
		cronogramaEventoNow.setFecha(cronogramaEvento.getFecha());
		cronogramaEventoNow.setCreatedAt(cronogramaEvento.getCreatedAt());
		cronogramaEventoNow.setUpdatedAt(cronogramaEvento.getUpdatedAt());
		cronogramaEventoNow.setRemove(cronogramaEvento.isRemove());
		cronogramaEventoNow.setDescripcion(cronogramaEvento.getDescripcion());
		
		return cronogramaEventoRepository.save(cronogramaEventoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		cronogramaEventoRepository.deleteById(id);
	}
}
