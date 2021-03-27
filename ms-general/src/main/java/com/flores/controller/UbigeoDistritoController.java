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

import com.flores.model.UbigeoDistrito;
import com.flores.model.dto.UbigeoDistritoDto;
import com.flores.repository.UbigeoDistritoRepository;

@RestController
@RequestMapping("/ubigeodistrito")
public class UbigeoDistritoController {

	@Autowired
	private UbigeoDistritoRepository distritoRepository;
	
	@GetMapping(path="/listarPorProvincia/{id}")
	private List<UbigeoDistrito> listarPorProvincia(@PathVariable int id){
		return distritoRepository.findAllByUbigeoProvinciaId(id);
	}
	
	@GetMapping(path = "/listar")
	private List<UbigeoDistrito> listar() {
		return distritoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<UbigeoDistrito> show(@PathVariable int id) {
		return distritoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private UbigeoDistrito create(@RequestBody UbigeoDistritoDto ubigeoDistritoDto) {
		UbigeoDistrito ubigeoDis = new UbigeoDistrito();
		ubigeoDis.setNombre(ubigeoDistritoDto.getNombre());
		ubigeoDis.setUbigeoProvinciaId(ubigeoDistritoDto.getUbigeoProvinciaId());
		return distritoRepository.save(ubigeoDis);
	}
	
	@PutMapping(path ="/{id}")
	private UbigeoDistrito update(@RequestBody UbigeoDistritoDto ubigeoDistrito,@PathVariable int id) {
		UbigeoDistrito ubigeoDistritoNow = distritoRepository.findById(id).orElse(null);
		ubigeoDistritoNow.setNombre(ubigeoDistrito.getNombre());
		ubigeoDistritoNow.setUbigeoProvinciaId(ubigeoDistrito.getUbigeoProvinciaId());
		
		return distritoRepository.save(ubigeoDistritoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		distritoRepository.deleteById(id);
	}
}
