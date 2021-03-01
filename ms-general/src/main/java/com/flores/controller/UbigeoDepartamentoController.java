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

import com.flores.model.UbigeoDepartamento;
import com.flores.model.dto.UbigeoDepartamentoDto;
import com.flores.repository.UbigeoDepartamentoRespository;

@RestController
@RequestMapping("/ubigeodepartamento")
public class UbigeoDepartamentoController {

	@Autowired
	private UbigeoDepartamentoRespository departamentoRepository;
	
	@GetMapping(path = "/listar")
	private List<UbigeoDepartamento> listar() {
		return departamentoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<UbigeoDepartamento> show(@PathVariable int id) {
		return departamentoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private UbigeoDepartamento create(@RequestBody UbigeoDepartamentoDto ubigeoDepartamentoDto) {
		UbigeoDepartamento ubigeDep = new UbigeoDepartamento();
		ubigeDep.setNombre(ubigeoDepartamentoDto.getNombre());
		return departamentoRepository.save(ubigeDep);
	}
	
	@PutMapping(path ="/{id}")
	private UbigeoDepartamento update(@RequestBody UbigeoDepartamentoDto ubigeoDepartamento,@PathVariable int id) {
		UbigeoDepartamento ubigeoDepartamentoNow = departamentoRepository.findById(id).orElse(null);
		ubigeoDepartamentoNow.setNombre(ubigeoDepartamento.getNombre());
		
		return departamentoRepository.save(ubigeoDepartamentoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		departamentoRepository.deleteById(id);
	}
	
}
