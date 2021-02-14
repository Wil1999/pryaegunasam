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
	private Noticia create(@RequestBody Noticia noticia) {
		return noticiaRepository.save(noticia);
	}
	
	@PutMapping(path ="/{id}")
	private Noticia update(@RequestBody Noticia noticia,@PathVariable int id) {
		Noticia noticiaNow = noticiaRepository.findById(id).orElse(null);
		noticiaNow.setTitulo(noticia.getTitulo());
		noticiaNow.setHtml(noticia.getHtml());
		noticiaNow.setEstado(noticia.isEstado());
		noticiaNow.setFechaPublicacion(noticia.getFechaPublicacion());
		noticiaNow.setAutor(noticia.getAutor());
		noticiaNow.setCreatedAt(noticia.getCreatedAt());
		noticiaNow.setUpdatedAt(noticia.getUpdatedAt());
		noticiaNow.setUsuarioId(noticia.getUsuarioId());
		noticiaNow.setRemove(noticia.isRemove());
		
		return noticiaRepository.save(noticiaNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		noticiaRepository.deleteById(id);
	}
}
