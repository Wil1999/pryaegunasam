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

import com.flores.feign.clients.ImagenClientRest;
import com.flores.feign.models.Imagen;
import com.flores.model.Evento;
import com.flores.repository.EventoRepository;

@RestController
@RequestMapping("evento")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ImagenClientRest imagenClientRest;
	
	@GetMapping("/listByImagen")
	private List<Evento> listByImagen(){
		List<Evento> evento = eventoRepository.findAll();
		for(Evento e: evento){
			List<Imagen> dato = imagenClientRest.listByEvento(e.getId()).orElse(null);
			e.setImagen(dato);
		}
		return evento;
	}

	@GetMapping("/listar")
	private List<Evento> show(){
		return eventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<Evento> show(@PathVariable int id) {
		return eventoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private Evento create(@RequestBody Evento evento) {
		return eventoRepository.save(evento);
	}
	
	@PutMapping(path ="/{id}")
	private Evento update(@RequestBody Evento evento,@PathVariable int id) {
		Evento eventoNow = eventoRepository.findById(id).orElse(null);
		eventoNow.setTitulo(evento.getTitulo());
		eventoNow.setDescripcion(evento.getDescripcion());
		eventoNow.setFechaInicio(evento.getFechaInicio());
		eventoNow.setFechaTermino(evento.getFechaTermino());
		eventoNow.setDetalle(evento.getDetalle());
		eventoNow.setEstado(evento.isEstado());
		eventoNow.setCosto(evento.getCosto());
		eventoNow.setDescuentoAsociado(evento.getDescuentoAsociado());
		eventoNow.setCreatedAt(evento.getCreatedAt());
		eventoNow.setUpdatedAt(eventoNow.getUpdatedAt());
		eventoNow.setRemove(evento.isRemove());
		eventoNow.setUsuarioId(evento.getUsuarioId());
		eventoNow.setCronogramaEvento(evento.getCronogramaEvento());
		eventoNow.setSituacionEvento(evento.getSituacionEvento());
		eventoNow.setInstructor(evento.getInstructor());
		eventoNow.setTipoEvento(eventoNow.getTipoEvento());
		
		return eventoRepository.save(eventoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		eventoRepository.deleteById(id);
	}
}
