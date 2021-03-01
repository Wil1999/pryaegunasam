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

import com.flores.model.Noticia;
import com.flores.model.dto.NoticiaDto;
import com.flores.repository.NoticiaRepository;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@GetMapping("/listar")
	private List<Noticia> show(){
		return noticiaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Noticia> show(@PathVariable int id) {
		return noticiaRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Noticia create(@RequestBody NoticiaDto noticiaDto) {
		Noticia noticia = new Noticia();
		noticia.setTitulo(noticiaDto.getTitulo());
		noticia.setDescripcion(noticiaDto.getDescripcion());
		noticia.setEstado(noticiaDto.isEstado());
		noticia.setFechaPublicacion(noticiaDto.getFechaPublicacion());
		noticia.setAutor(noticiaDto.getAutor());
		noticia.setCreatedAt(noticiaDto.getCreatedAt());
		noticia.setUpdatedAt(noticiaDto.getUpdatedAt());
		noticia.setUsuarioId(noticiaDto.getUsuarioId());
		noticia.setRemove(noticiaDto.isRemove());
		return noticiaRepository.save(noticia);
	}
	
	@PutMapping(path ="/{id}")
	private Noticia update(@RequestBody NoticiaDto noticiaDto,@PathVariable int id) {
		Noticia noticiaNow = noticiaRepository.findById(id).orElse(null);
		noticiaNow.setTitulo(noticiaDto.getTitulo());
		noticiaNow.setDescripcion(noticiaDto.getDescripcion());
		noticiaNow.setEstado(noticiaDto.isEstado());
		noticiaNow.setFechaPublicacion(noticiaDto.getFechaPublicacion());
		noticiaNow.setAutor(noticiaDto.getAutor());
		noticiaNow.setCreatedAt(noticiaDto.getCreatedAt());
		noticiaNow.setUpdatedAt(noticiaDto.getUpdatedAt());
		noticiaNow.setUsuarioId(noticiaDto.getUsuarioId());
		noticiaNow.setRemove(noticiaDto.isRemove());
		
		return noticiaRepository.save(noticiaNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		noticiaRepository.deleteById(id);
	}
}
