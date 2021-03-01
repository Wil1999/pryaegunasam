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

import com.flores.model.TipoEvento;
import com.flores.model.dto.TipoEventoDto;
import com.flores.repository.TipoEventoRepository;

@RestController
@RequestMapping("/tipoevento")
public class TipoEventoController {

	@Autowired
	private TipoEventoRepository tipoEventoRepository;
	
	@GetMapping("/listar")
	private List<TipoEvento> show(){
		return tipoEventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<TipoEvento> show(@PathVariable int id) {
		return tipoEventoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private TipoEvento create(@RequestBody TipoEventoDto tipoEvento) {
		TipoEvento tipoEventoNow = new TipoEvento();
		tipoEventoNow.setNombre(tipoEvento.getNombre());
		tipoEventoNow.setCreatedAt(tipoEvento.getCreatedAt());
		tipoEventoNow.setUpdatedAt(tipoEvento.getUpdatedAt());
		tipoEventoNow.setEstado(tipoEvento.getEstado());
		return tipoEventoRepository.save(tipoEventoNow);
	}
	
	@PutMapping(path ="/{id}")
	private TipoEvento update(@RequestBody TipoEventoDto tipoEvento,@PathVariable int id) {
		TipoEvento tipoEventoNow = tipoEventoRepository.findById(id).orElse(null);
		tipoEventoNow.setNombre(tipoEvento.getNombre());
		tipoEventoNow.setCreatedAt(tipoEvento.getCreatedAt());
		tipoEventoNow.setUpdatedAt(tipoEvento.getUpdatedAt());
		tipoEventoNow.setEstado(tipoEvento.getEstado());
		
		return tipoEventoRepository.save(tipoEventoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		tipoEventoRepository.deleteById(id);
	}
}
