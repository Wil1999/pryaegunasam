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
	private Imagen create(@RequestBody Imagen imagen) {
		return imagenRepository.save(imagen);
	}
	
	@PutMapping(path ="/{id}")
	private Imagen update(@RequestBody Imagen imagen,@PathVariable int id) {
		Imagen imagenNow = imagenRepository.findById(id).orElse(null);
		imagenNow.setTitulo(imagen.getTitulo());
		imagenNow.setDescripcion(imagen.getDescripcion());
		imagenNow.setUrl(imagen.getUrl());
		imagenNow.setNoticia(imagen.getNoticia());
		imagenNow.setNoticia(imagen.getNoticia());
		imagenNow.setCreatedAt(imagen.getCreatedAt());
		imagenNow.setUpdatedAt(imagen.getUpdatedAt());
		imagenNow.setEstado(imagen.getEstado());
		imagenNow.setUsuarioId(imagen.getUsuarioId());
		imagenNow.setRemove(imagen.isRemove());
		
		return imagenRepository.save(imagenNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		imagenRepository.deleteById(id);
	}
}
