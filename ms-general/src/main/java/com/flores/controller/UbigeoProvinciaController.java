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

import com.flores.model.UbigeoProvincia;
import com.flores.repository.UbigeoProvinciaRepository;

@RestController
@RequestMapping("/ubigeoprovincia")
public class UbigeoProvinciaController {

	@Autowired
	private UbigeoProvinciaRepository provinciaRepository;
	
	@GetMapping(path = "/listar")
	private List<UbigeoProvincia> listar() {
		return provinciaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<UbigeoProvincia> show(@PathVariable int id) {
		return provinciaRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private UbigeoProvincia create(@RequestBody UbigeoProvincia ubigeoProvincia) {
		return provinciaRepository.save(ubigeoProvincia);
	}
	
	@PutMapping(path ="/{id}")
	private UbigeoProvincia update(@RequestBody UbigeoProvincia ubigeoProvincia,@PathVariable int id) {
		UbigeoProvincia ubigeoProvinciaNow = provinciaRepository.findById(id).orElse(null);
		ubigeoProvinciaNow.setNombre(ubigeoProvincia.getNombre());
		ubigeoProvinciaNow.setUbigeoDepartamento(ubigeoProvincia.getUbigeoDepartamento());
		
		return provinciaRepository.save(ubigeoProvinciaNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		provinciaRepository.deleteById(id);
	}
}
