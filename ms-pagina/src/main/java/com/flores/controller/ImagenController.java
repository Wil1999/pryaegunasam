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

import com.flores.model.Imagen;
import com.flores.model.dto.ImagenDto;
import com.flores.repository.ImagenRepository;

@RestController
@RequestMapping("/imagen")
public class ImagenController {

	@Autowired
	private ImagenRepository imagenRepository;
	
	@GetMapping("/listByEvento/{id}")
	private Optional<List<Imagen>> listByEvento(@PathVariable int id){
		return imagenRepository.findAllByEventoId(id);
	}
	
	@GetMapping("/listar")
	private List<Imagen> show(){
		return imagenRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Imagen> show(@PathVariable int id) {
		return imagenRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Imagen create(@RequestBody ImagenDto imagenDto) {
		Imagen imagen = new Imagen();
		imagen.setUrl(imagenDto.getUrl());
		imagen.setNoticiaId(imagenDto.getNoticiaId());
		imagen.setEventoId(imagenDto.getEventoId());
		imagen.setCreatedAt(imagenDto.getCreatedAt());
		imagen.setUpdatedAt(imagenDto.getUpdatedAt());
		imagen.setEstado(imagenDto.getEstado());
		imagen.setPersonaId(imagenDto.getPersonaId());
		imagen.setRemove(imagenDto.isRemove());
		return imagenRepository.save(imagen);
	}
	
	@PutMapping(path ="/{id}")
	private Imagen update(@RequestBody ImagenDto imagenDto,@PathVariable int id) {
		Imagen imagenNow = imagenRepository.findById(id).orElse(null);
		imagenNow.setUrl(imagenDto.getUrl());
		imagenNow.setNoticiaId(imagenDto.getNoticiaId());
		imagenNow.setEventoId(imagenDto.getEventoId());
		imagenNow.setCreatedAt(imagenDto.getCreatedAt());
		imagenNow.setUpdatedAt(imagenDto.getUpdatedAt());
		imagenNow.setEstado(imagenDto.getEstado());
		imagenNow.setPersonaId(imagenDto.getPersonaId());
		imagenNow.setRemove(imagenDto.isRemove());
		
		return imagenRepository.save(imagenNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		imagenRepository.deleteById(id);
	}
}
