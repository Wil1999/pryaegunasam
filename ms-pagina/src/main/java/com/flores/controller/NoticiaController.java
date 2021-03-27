package com.flores.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.flores.model.dto.NoticiaResponse;
import com.flores.repository.NoticiaRepository;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@Autowired
	private EntityManager em;
	
	// Listar por año
	
	@SuppressWarnings("deprecation")
	@GetMapping("/listarNoticiaAño/{año}")
	private List<Noticia> listarNoticiaAño(@PathVariable int año){
		List<Noticia> response = noticiaRepository.findAll();
		List<Noticia> result = new ArrayList<Noticia>();
		
		for(Noticia n:response) {
			if(n.getFechaPublicacion().getYear() == año) {
				result.add(n);
			}
		}
		return result;
	} 
	
	//
	@GetMapping(path="/listarNoticias")
	private List<NoticiaResponse> listarNoticias(){
		List<Noticia> noticias = noticiaRepository.findAll();
		List<NoticiaResponse> noticiasResponse = new ArrayList<NoticiaResponse>();
		
		for(Noticia n: noticias) {
			NoticiaResponse noticiaResponse = new NoticiaResponse();
			noticiaResponse.setId(n.getId());
			Query nombre = em.createNativeQuery("select a.nombre from pagina.autor a, pagina.noticia n where n.id_autor = a.id and n.id =?");
			nombre.setParameter(1,n.getId());
			noticiaResponse.setAutor(nombre.getSingleResult().toString());
			noticiaResponse.setDescripcion(n.getDescripcion());
			noticiaResponse.setFechaPublicacion(n.getFechaPublicacion());
			noticiasResponse.add(noticiaResponse);
		}
		
		return noticiasResponse;
	}
	
	@PostMapping(path="/crearNoticia")
	private ResponseEntity<String> crearNoticia(@RequestBody NoticiaResponse noticia){
		Instant instant = Instant.now();
		Noticia noticiaNow = new Noticia();
		noticiaNow.setTitulo(noticia.getTitulo());
		noticiaNow.setDescripcion(noticia.getDescripcion());
		noticiaNow.setEstado(true);
		noticiaNow.setFechaPublicacion(noticia.getFechaPublicacion());
		Query nombreId = em.createNativeQuery("select a.id from pagina.autor a, pagina.noticia n where n.id_autor = a.id and a.nombre =?");
		nombreId.setParameter(1,noticia.getAutor());
		noticiaNow.setIdAutor(Integer.parseInt(nombreId.getSingleResult().toString()));
		noticiaNow.setCreatedAt(Timestamp.from(instant));
		noticiaNow.setUpdatedAt(Timestamp.from(instant));
		// noticiaNow.setUsuarioId(noticiaDto.getUsuarioId());
		noticiaNow.setRemove(noticia.isRemove());
		noticiaRepository.save(noticiaNow);
		return new ResponseEntity<String>("CREACION DE NOTICIA EXITOSA",HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/actualizarNoticia/{id}")
	private ResponseEntity<String> actualizarNoticia(@RequestBody NoticiaResponse noticia,@PathVariable int id){
		Instant instant = Instant.now();
		Noticia noticiaNow = noticiaRepository.findById(id).orElse(null);
		noticiaNow.setTitulo(noticia.getTitulo());
		noticiaNow.setDescripcion(noticia.getDescripcion());
		noticiaNow.setEstado(true);
		noticiaNow.setFechaPublicacion(noticia.getFechaPublicacion());
		Query nombreId = em.createNativeQuery("select a.id from pagina.autor a, pagina.noticia n where n.id_autor = a.id and a.nombre =?");
		nombreId.setParameter(1,noticia.getAutor());
		noticiaNow.setIdAutor(Integer.parseInt(nombreId.getSingleResult().toString()));
		noticiaNow.setUpdatedAt(Timestamp.from(instant));
		// noticiaNow.setUsuarioId(noticiaDto.getUsuarioId());
		noticiaNow.setRemove(noticia.isRemove());
		noticiaRepository.save(noticiaNow);
		return new ResponseEntity<String>("ACTUALIZACION DE NOTICIA EXITOSA",HttpStatus.ACCEPTED);
	}
	//
	
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
		noticia.setIdAutor(noticiaDto.getIdAutor());
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
		noticiaNow.setIdAutor(noticiaDto.getIdAutor());
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
