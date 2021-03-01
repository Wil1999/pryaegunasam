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

import com.flores.model.TipoTelefono;
import com.flores.model.dto.TipoTelefonoDto;
import com.flores.repository.TipoTelefonoRepository;

@RestController
@RequestMapping("tipotelefono")
public class TipoTelefonoController {

	@Autowired
	private TipoTelefonoRepository tipoTelefonoRepository;
	
	
	@GetMapping(path = "/listar")
	private List<TipoTelefono> listar() {
		return tipoTelefonoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	private Optional<TipoTelefono> show(@PathVariable int id) {
		return tipoTelefonoRepository.findById(id);
	}
	
	@PostMapping(path="/nuevo")
	private TipoTelefono create(@RequestBody TipoTelefonoDto tipoTelefono) {
		TipoTelefono tipoTelefonoNow = new TipoTelefono();
		tipoTelefonoNow.setTipoTelefono(tipoTelefono.getTipoTelefono());
		return tipoTelefonoRepository.save(tipoTelefonoNow);
	}
	
	@PutMapping(path ="/{id}")
	private TipoTelefono update(@RequestBody TipoTelefono tipoTelefono,@PathVariable int id) {
		TipoTelefono tipoTelefonoNow = tipoTelefonoRepository.findById(id).orElse(null);
		tipoTelefonoNow.setTipoTelefono(tipoTelefono.getTipoTelefono());
		
		return tipoTelefonoRepository.save(tipoTelefonoNow);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable int id) {
		tipoTelefonoRepository.deleteById(id);
	}
}
